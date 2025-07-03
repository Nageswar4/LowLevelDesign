package com.threadconcurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        // Semaphore with 2 permits
		Semaphore semaphore = new Semaphore(2);

        // Create 5 worker threads
        for (int i = 1; i <= 5; i++) {
            Thread t = new Thread(new Worker(semaphore, "Thread-" + i));
            t.start();
        }
    }

    static class Worker implements Runnable {
        private Semaphore semaphore;
        private String name;

        public Worker(Semaphore semaphore, String name) {
            this.semaphore = semaphore;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " waiting for permit...");
                
                // Acquire a permit (blocks if none available)
                semaphore.acquire();
                
                System.out.println(name + " acquired permit!");

                // Simulate work in critical section
                Thread.sleep(2000);

                System.out.println(name + " releasing permit.");
                
                // Release the permit
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}