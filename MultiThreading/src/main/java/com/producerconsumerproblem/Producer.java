package com.producerconsumerproblem;

public class Producer implements Runnable {

	private MessageQueue queueData;
	private boolean isRunning = true;
	private static int count = 0;

	public Producer(MessageQueue queue) {
		this.queueData = queue;
	}

	@Override
	public void run() {
		produce();

	}

	private void produce() {
		while (isRunning) {

			Message message = new Message(count++, "Mesage");

			try {
				queueData.add(message);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

	}

	public void stop() {
		this.isRunning = false;

	}

}
