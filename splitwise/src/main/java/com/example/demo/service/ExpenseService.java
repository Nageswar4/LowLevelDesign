package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.demo.beans.Expense;
import com.example.demo.beans.Split;
import com.example.demo.beans.User;
import com.example.demo.splitting.SplittingStrategy;
import com.example.demo.splitting.SplittingStrategyFactory;

public class ExpenseService {
	private static ExpenseService expenseService;
	private UserService userService;
	private Map<String, Expense> expenseMap;

	private ExpenseService() {
		this.expenseMap = new ConcurrentHashMap<>();

	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public static ExpenseService getInstance() {
		if (expenseService == null) {
			synchronized (ExpenseService.class) {
				if (expenseService == null) {
					expenseService = new ExpenseService();
				}
			}
		}
		return expenseService;
	}

	public Map<String, Object> addExpense(Expense expense) {
		if (this.userService == null) {
			userService = UserService.getInstance();
		}
		Map<String, Object> resultMap = new HashMap<>();
		try {
			if (!getValidation(expense) || this.expenseMap.containsKey(expense.getExpenseId())) {
				resultMap.put(expense.getExpenseId(), "Invalid Expense for Expense Id is: " + expense.getExpenseId());
				return resultMap;
			}
			User payer = userService.getUser(expense.getUserPaid());

			for (Split split : expense.getSplits()) {
				User user = userService.getUser(split.getUserId());
				if (!payer.getUserId().equalsIgnoreCase(user.getUserId())) {
					User first = payer.getUserId().compareTo(user.getUserId()) < 0 ? payer : user;
					User second = first == payer ? user : payer;

					first.getLock().lock();
					second.getLock().lock();

					try {
						double amount = split.getAmount();
						payer.getBalanceMap().put(user.getUserId(),
								payer.getBalanceMap().getOrDefault(user.getUserId(), 0.0) + amount);
						payer.setAmountOwns(payer.getAmountOwns() + amount);

						user.getBalanceMap().put(payer.getUserId(),
								user.getBalanceMap().getOrDefault(payer.getUserId(), 0.0) - amount);
						user.setAmountOwns(user.getAmountOwns() - amount);
					} finally {
						second.getLock().unlock();
						first.getLock().unlock();
					}

				}
			}
			this.expenseMap.put(expense.getExpenseId(), expense);
		} catch (Exception e) {

			resultMap.put(expense.getExpenseId(), e.getMessage());
			return resultMap;

		}
		resultMap.put(expense.getExpenseId(), "Expense Added for Expense id is: " + expense.getExpenseId());

		return resultMap;

	}

	private boolean getValidation(Expense expense) throws Exception {

		SplittingStrategy strategy = SplittingStrategyFactory.getStrategy(expense.getSplitType());
		if (strategy != null) {
			return strategy.isValid(expense);
		}
		return false;

	}

	public Map<String, Expense> getAllExpenses() {
		return expenseMap;
	}

}
