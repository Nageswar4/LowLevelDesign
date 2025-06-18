package com.rover.controller;

public class RoverBootstrapping {

	private Moveable[][] moveable;

	public void intialize(int count) {

		this.moveable = new Moveable[count][count];

	}
	/*
	 * public void addRover(int row, int col) {
	 * 
	 * if (row < moveable.length && col < moveable.length && this.moveable[row][col]
	 * == null) { Rover rover = new Rover(); rover.row = row; rover.col = col;
	 * this.moveable[row][col] = new Rover();
	 * 
	 * }
	 * 
	 * else { System.out.println("Invalid Row and Col Size please check " +
	 * "row is :" + row + " Col size is " + col); }
	 * 
	 * }
	 * 
	 * public void addObstacle(int row, int col) { if (row < moveable.length && col
	 * < moveable.length && this.moveable[row][col] == null) { Obstacle obs = new
	 * Obstacle(); obs.row = row; obs.col = col; this.moveable[row][col] = obs;
	 * 
	 * }
	 * 
	 * else System.out.println("Invalid Row and Col Size please check " + "row is :"
	 * + row + " Col size is " + col); }
	 */

	public Moveable[][] getMoveableMatrix() {
		return this.moveable;
	}

}
