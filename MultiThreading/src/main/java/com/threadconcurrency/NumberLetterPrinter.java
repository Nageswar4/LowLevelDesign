package com.threadconcurrency;

public class NumberLetterPrinter {

	public static void main(String[] args) {
		Object lock = new Object();

		Thread thread = new Thread(() -> {

			for (int i = 1; i <= 26; i++) {

				synchronized (lock) {
					System.out.println(i);
					lock.notify();

					if (i < 26) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
			}

		});

		Thread letterThread = new Thread(() -> {

			for (int i = 1; i <= 26; i++) {

				synchronized (lock) {
					char ch = (char) ('A' + i - 1);
					System.out.println(ch);
					lock.notify();
					if (i < 26) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
			}

		});

		thread.start();
		letterThread.start();
	}

}
