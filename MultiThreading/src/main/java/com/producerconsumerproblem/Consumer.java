package com.producerconsumerproblem;

public class Consumer implements Runnable {
	private MessageQueue dataQueue;
	private boolean isRunning = true;

	public Consumer(MessageQueue queue) {
		this.dataQueue = queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		consume();
	}

	private void consume() {

		while (isRunning) {
			try {
				Message message = this.dataQueue.remove();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}

	}

	public void stop() {
		this.isRunning = false;
	}

}
