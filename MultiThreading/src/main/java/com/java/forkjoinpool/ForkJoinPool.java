package com.java.forkjoinpool;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ForkJoinPool {
	List<String> b = Arrays.asList("a", "b");
	private final static List<String> a = Arrays.asList("a", "b");

	public static void main(String[] args) {

		ForkJoinPoolExecutor executor = new ForkJoinPoolExecutor(10);
		for (int i = 0; i < 20; i++) {
			final int taskNum = i;
			executor.submit(() -> {
				System.out.println(" Executing TaskNumber is " + taskNum + " :");

			});
		}
		a.add("B");
		Collections.sort(a);

	}

}
