package com.example.demo.splitting;

import java.util.List;

import com.example.demo.beans.Expense;
import com.example.demo.beans.Split;
import com.example.demo.exceptions.InvalidSplitSizeException;

public class PercentageSplit implements SplittingStrategy {
	private static final double EPSILON = 0.01;

	@Override
	public boolean isValid(Expense expense) throws InvalidSplitSizeException {

		double exactSplitAmount = expense.getAmount();
		List<Split> splits = expense.getSplits();
		double totalPercentage = 0.0;
		int splitCount = splits.size();
		if (splitCount <= 0) {
			throw new InvalidSplitSizeException("Invalid Size");
		}

		for (Split split : splits) {
			double splitAmount = split.getAmount();
			totalPercentage = totalPercentage + split.getPercentage();
			double calculatedSplitAmount = (split.getPercentage() * exactSplitAmount) / 100;
			if (Math.abs(splitAmount - calculatedSplitAmount) > EPSILON) {
				return false;
			}
		}

		return Math.abs(totalPercentage - 100.0) <= EPSILON;
	}

}
