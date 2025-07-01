package com.customthreadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPoolExecutor {
	private final BlockingQueue<Runnable> blockingQueue;
	private final WorkerThread[] workerThreads;
	private boolean isStopped = false;

	public CustomThreadPoolExecutor(int poolSize) {
		blockingQueue = new LinkedBlockingQueue<>();
		this.workerThreads = new WorkerThread[poolSize];
		for (int i = 0; i < poolSize; i++) {
			workerThreads[i] = new WorkerThread(blockingQueue);
			workerThreads[i].start();
		}
	}

	public void submit(Runnable runnable) throws IllegalStateExeception {
		if (isStopped)
			throw new IllegalStateExeception("ThreadPool is stopped");
		this.blockingQueue.offer(runnable);
		return;
	}

	public void shutdown() {
		isStopped = true;
		for (WorkerThread worker : workerThreads) {
			worker.interrupt();
		}
	}
}
