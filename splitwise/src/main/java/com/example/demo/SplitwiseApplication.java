package com.example.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.beans.Expense;
import com.example.demo.beans.Split;
import com.example.demo.beans.SplitType;
import com.example.demo.beans.User;
import com.example.demo.service.ExpenseService;
import com.example.demo.service.GroupService;
import com.example.demo.service.UserService;

@SpringBootApplication
public class SplitwiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
		System.out.println("Started Split Wise Application");
	}

	@Bean
	public CommandLineRunner runOnStartup() {
		return args -> {
			System.out.println("🚀 Bootstrapping Splitwise Test Data...");

			// Step 1: Create Users
			UserService userService = UserService.getInstance();
			userService.createUser(new User("U1", "Alice", new ConcurrentHashMap<>(), 0.0, new Date()));
			userService.createUser(new User("U2", "Bob", new ConcurrentHashMap<>(), 0.0, new Date()));
			userService.createUser(new User("U3", "Charlie", new ConcurrentHashMap<>(), 0.0, new Date()));

			// Step 2: Create Group
			GroupService groupService = GroupService.getInstance();
			List<String> members = Arrays.asList("U1", "U2", "U3");
			groupService.createGroup("G1", "TripToGoa", members);

			// Step 3: Create Expense
			ExpenseService expenseService = ExpenseService.getInstance();
			expenseService.setUserService(userService);

			List<Split> splits = Arrays.asList(new Split("U1", 300, 0.0), new Split("U2", 300, 0.0),
					new Split("U3", 300, 0.0));

			Expense expense = new Expense();
			expense.setAmount(900.00);
			expense.setExpenseId("E1");
			expense.setUserPaid("U1");
			expense.setSplits(splits);
			expense.setGroupId("G1");
			expense.setSpitType(SplitType.EQUAL);

			Map<String, Object> result = expenseService.addExpense(expense);
			System.out.println(result);

			groupService.addExpense(expense);

			// Print balances
			System.out.println("📊 Balances after expense:");
			System.out.println("Alice: " + userService.getUser("U1").getBalanceMap());
			System.out.println("Bob: " + userService.getUser("U2").getBalanceMap());
			System.out.println("Charlie: " + userService.getUser("U3").getBalanceMap());

			// Group details
			System.out.println("👥 Group G1 Details: " + groupService.getGroup("G1").getExpenseIds()
					+ " User Details : " + groupService.getGroup("G1").getUserId());
		};
	}

}
