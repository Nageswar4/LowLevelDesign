package com.example.snakeandladder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.snakeandladder.beans.Game;

@SpringBootApplication
public class SnakeandLadderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnakeandLadderApplication.class, args);
	}

	@Bean
	public CommandLineRunner onRun() {
		return args -> {

			Game game = Game.getInstance();
			game.start();

		};

	}

}
