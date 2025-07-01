package com.customthreadpool;

import java.util.concurrent.BlockingQueue;

public class WorkerThread extends Thread {

	private final BlockingQueue<Runnable> blockingQueue;

	public WorkerThread(BlockingQueue<Runnable> queue) {
		this.blockingQueue = queue;
	}

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {

			Runnable task = null;
			try {
				task = this.blockingQueue.take();
				task.run();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();

			}

		}
	}

}
