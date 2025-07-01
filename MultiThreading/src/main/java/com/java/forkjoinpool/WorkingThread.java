package com.java.forkjoinpool;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class WorkingThread extends Thread {
	private WorkingThread[] allWorkers;
	private BlockingDeque<Runnable> queue;
	private int id;
	private AtomicBoolean inc = new AtomicBoolean(true);

	public WorkingThread(WorkingThread[] allWorkers, BlockingDeque<Runnable> queue, int id) {
		this.allWorkers = allWorkers;
		this.queue = queue;
		this.id = id;
	}

	public void run() {

		while (inc.get() || !queue.isEmpty()) {

			Runnable task = queue.pollFirst();
			if (task == null) {
				task = getSteal();

				if (task == null) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					continue;
				}
				
				task.run();
			}

		}

	}

	private Runnable getSteal() {
		for (WorkingThread worker : allWorkers) {
			if (this == worker)
				continue;

			BlockingDeque<Runnable> victimQueue = worker.queue;
			Runnable task = victimQueue.pollLast();
			if (task == null) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			return task;

		}
		return null;
	}

	public void shutdown() {
		inc.set(false);
		Thread.currentThread().interrupt();

	}
}
