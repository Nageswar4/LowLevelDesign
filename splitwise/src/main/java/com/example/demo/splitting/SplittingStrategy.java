package com.example.demo.splitting;

import com.example.demo.beans.Expense;

public interface SplittingStrategy {
	public boolean isValid(Expense expense) throws Exception;

}
