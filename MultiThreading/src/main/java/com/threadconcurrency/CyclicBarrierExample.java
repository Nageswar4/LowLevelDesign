package com.threadconcurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		int totalThreads = 3;

		CyclicBarrier barrier = new CyclicBarrier(3,() -> {
		    System.out.println("All threads reached the barrier. Barrier action executed!");
		});

		Runnable task = () -> {
			try {
				for (int i = 0; i <= 2; i++) {
					System.out.println(
							Thread.currentThread().getName() + "Round  No is Started : " + i + " is working...");
					
					System.out.println(
							Thread.currentThread().getName() + "Round  No is : " + i + " reached the barrier.");
					barrier.await(); // ⛔ Wait until all threads reach here
					Thread.sleep(1000);
					System.out.println(
							Thread.currentThread().getName() + "Round  No is : " + i + " continues execution...");
				}

			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		};

		for (int i = 0; i < totalThreads; i++) {
			new Thread(task, "Thread-" + i).start();
		}
	}

}
