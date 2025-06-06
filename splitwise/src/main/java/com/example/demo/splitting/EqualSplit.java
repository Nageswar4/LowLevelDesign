package com.example.demo.splitting;

import java.util.List;

import com.example.demo.beans.Expense;
import com.example.demo.beans.Split;
import com.example.demo.exceptions.InvalidSplitSizeException;

public class EqualSplit implements SplittingStrategy {
	private static final double EPSILON = 0.01;

	@Override
	public boolean isValid(Expense expense) throws InvalidSplitSizeException {

		List<Split> splits = expense.getSplits();
		int size = splits.size();
		double totalAmount = 0.0;
		double exactSplitamount = expense.getAmount();
		double expectedSplitAmount = exactSplitamount / splits.size();
		if (size <= 0) {
			throw new InvalidSplitSizeException("Invalid Splits size");
		}

		for (Split split : splits) {
			totalAmount = totalAmount + split.getAmount();
			if (Math.abs(expectedSplitAmount - split.getAmount()) > EPSILON)
				return false;
		}

		return Math.abs(totalAmount - exactSplitamount) <= EPSILON;
	}

}
