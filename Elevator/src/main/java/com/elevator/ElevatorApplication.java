package com.elevator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.elevator.beans.Elevator;

@SpringBootApplication
public class ElevatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElevatorApplication.class, args);
	}

	@Bean
	public CommandLineRunner onRun() {

		return ars -> {
			Elevator elevator = Elevator.getInstance();
			elevator.setElevatorId(1);

			// Elevator is initially idle at floor 0
			System.out.println("Current Floor: " + elevator.getCurrentFloorId());

			// Add some floor requests
			elevator.pressFloorButtonInside(5); // Goes up
			elevator.move(); // Move to floor 5
			System.out.println("After move 1 -> Floor: " + elevator.getCurrentFloorId());

			elevator.pressFloorButtonInside(2); // Now should be handled after moving up
			elevator.pressFloorButtonInside(6); // Another upward request
			elevator.move(); // Goes to floor 6
			System.out.println("After move 2 -> Floor: " + elevator.getCurrentFloorId());

			elevator.move(); // Now handle floor 2 (will switch to down state)
			System.out.println("After move 3 -> Floor: " + elevator.getCurrentFloorId());

			elevator.move(); // All queues empty, goes idle
			System.out.println("Final state should be idle");

		};

	}

}
