package com.rover.direction;

import com.rover.controller.Moveable;
import com.rover.controller.Rover;

public class DownDirection implements Direction {

	@Override
	public boolean isValidMove(Rover rover, Moveable[][] moveable) {

		int row = rover.getRow();
		int col = rover.getCol();

		int newRow = row + 1;

		return newRow < moveable.length && moveable[newRow][col] == null;

	}

	@Override
	public boolean move(Rover rover, Moveable[][] moveable) {
		if (!isValidMove(rover, moveable))
			return false;
		int row = rover.getRow();
		int col = rover.getCol();
		int newRow = row + 1;
		rover.setRow(newRow);
		moveable[row][col] = null;
		moveable[newRow][col] = rover;
		return true;
	}

}
