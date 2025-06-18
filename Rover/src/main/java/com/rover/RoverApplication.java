package com.rover;

import com.rover.direction.Direction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rover.controller.Moveable;
import com.rover.controller.Obstacle;
import com.rover.controller.Rover;
import com.rover.controller.RoverBootstrapping;
import com.rover.direction.RightDirection;

@SpringBootApplication
public class RoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoverApplication.class, args);
	}

	@Bean
	public CommandLineRunner onRun() {
		return ars -> {

			Rover rover = new Rover();
			rover.setRow(0);
			rover.setCol(0);

			Obstacle obs = new Obstacle();

			obs.setCol(3);
			obs.setRow(0);

			RoverBootstrapping roverBootstrapping = new RoverBootstrapping();
			roverBootstrapping.intialize(8);

			Moveable[][] moveable = roverBootstrapping.getMoveableMatrix();
			moveable[0][0] = rover;
			moveable[0][3] = obs;
			Direction dir = new RightDirection();

			System.out.println(dir.move(rover, moveable));
			System.out.println(dir.move(rover, moveable));
			System.out.println(dir.move(rover, moveable));

		};

	}

}
