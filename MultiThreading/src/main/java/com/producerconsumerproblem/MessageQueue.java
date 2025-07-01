package com.producerconsumerproblem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MessageQueue {

	private final Queue<Message> queue = new LinkedList<>();
	private final int maxSize;
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition notEmpty = lock.newCondition();
	private final Condition notFull = lock.newCondition();

	public MessageQueue(int count) {
		this.maxSize = count;
	}

	public void add(Message message) throws InterruptedException {
		lock.lock();
		try {
			while (queue.size() == maxSize) {
				notFull.await();
			}
			queue.add(message);
			System.out.println(message.toString() +"  :In Add Method ");
			notEmpty.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public Message remove() throws InterruptedException {
		Message message = null;
		lock.lock();
		try {
			while (queue.isEmpty()) {
				notEmpty.await();
			}
			message = queue.remove();
			System.out.println(message.toString() +"  :In Remove Method ");
			notFull.signalAll();
		} finally {
			lock.unlock();
		}
		return message;
	}

	public boolean isFull() {
		return this.queue.size() == this.maxSize;
	}

	public boolean isEmpty() {
		return this.queue.isEmpty();
	}

}
