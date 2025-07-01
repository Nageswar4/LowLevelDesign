package com.java.forkjoinpool;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class ForkJoinPoolExecutor {

	private BlockingDeque<Runnable>[] queue;
	private WorkingThread[] allWorkers;
	private final AtomicInteger taskSubmitter = new AtomicInteger(0);

	public ForkJoinPoolExecutor(int poolSize) {

		this.queue = new BlockingDeque[poolSize];
		allWorkers = new WorkingThread[poolSize];

		for (int i = 0; i < poolSize; i++) {
			this.queue[i] = new LinkedBlockingDeque<>();
		}

		for (int i = 0; i < poolSize; i++) {
			allWorkers[i] = new WorkingThread(allWorkers, queue[i], i);
			allWorkers[i].start();
		}

	}

	public void submit(Runnable runnable) {

		int idx = taskSubmitter.getAndIncrement() % allWorkers.length;

		try {
			queue[idx].putFirst(runnable);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void shutdown() {
		for (WorkingThread worker : allWorkers) {
			worker.shutdown();
		}
		for (WorkingThread worker : allWorkers) {
			try {
				worker.join();
			} catch (InterruptedException ignored) {
			}
		}
	}
}
