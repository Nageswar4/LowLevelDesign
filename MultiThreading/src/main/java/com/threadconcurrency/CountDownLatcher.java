package com.threadconcurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatcher {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		CountDownLatch latcher = new CountDownLatch(3);

		Runnable task = () -> {
			System.out.println("Thread Name is: " + Thread.currentThread().getName());
			latcher.countDown();

		};

		for (int i = 0; i < 3; i++) {
			executor.submit(task);
		}
		System.out.println("Running in Main Thread Before Latch is called : " + Thread.currentThread().getName());
		try {
			latcher.await();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("After reaching a common Point: " + Thread.currentThread().getName());

	}

}
