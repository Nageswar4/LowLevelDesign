package com.customthreadpool;

public class CustomThreadPoolMain {

	public static void main(String[] args) {

		CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(5);
		for (int i = 0; i <= 10; i++) {
			final int taskNum = i;
			try {

				executor.submit(() -> {
					System.out.println("Running Thread Name is " + taskNum + " :");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}

				});

			} catch (IllegalStateExeception e) {

				e.printStackTrace();
			}
		}

		try {
			Thread.sleep(10000);
			executor.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
