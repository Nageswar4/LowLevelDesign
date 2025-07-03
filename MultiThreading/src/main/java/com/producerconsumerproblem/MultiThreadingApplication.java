package com.producerconsumerproblem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MultiThreadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiThreadingApplication.class, args);
	}

	@Bean
	public CommandLineRunner onRun() {

		return ars -> {
			MessageQueue queue = new MessageQueue(5);
			Producer pr = new Producer(queue);
			Thread t1 = new Thread(pr);
			Consumer cs = new Consumer(queue);
			Thread t2 = new Thread(cs);
			t1.start();
			t2.start();

		};

	}
}
