package com.example.snakeandladder.beans;

import java.util.Random;

public class Dice {
	private final int noOfRolls;
	Random random = new Random();
	public Dice(int count) {
		this.noOfRolls = count;
	}
	public int roll() {

		int sumCount = 0;
		int no = this.noOfRolls;
		while (no > 0) {
			sumCount = sumCount + random.nextInt(1, 7);
			no--;
		}

		return sumCount;

	}

}
