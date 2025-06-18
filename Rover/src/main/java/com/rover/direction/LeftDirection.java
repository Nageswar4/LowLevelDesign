package com.rover.direction;

import com.rover.controller.Moveable;
import com.rover.controller.Rover;

public class LeftDirection implements Direction {

	@Override
	public boolean isValidMove(Rover rover, Moveable[][] moveable) {

		int row = rover.getRow();
		int col = rover.getCol();

		int newCol = col - 1;

		return newCol < moveable[row].length && newCol >= 0 && moveable[row][newCol] == null;

	}

	@Override
	public boolean move(Rover rover, Moveable[][] moveable) {
		if (!isValidMove(rover, moveable))
			return false;
		int row = rover.getRow();
		int col = rover.getCol();
		int newCol = col - 1;
		rover.setCol(newCol);
		moveable[row][col] = null;
		moveable[row][newCol] = rover;
		return true;
	}

}
