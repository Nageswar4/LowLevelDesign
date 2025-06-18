package com.snake.direction;

import com.snake.beans.Cell;

public class DownDirection implements Direction {

	@Override
	public Cell getNextCell(Cell cell, Cell[][] board) {
		int col = cell.getCol();
		int row = cell.getRow();
		if (row+1 < board.length) {
			return new Cell(row + 1, col);
		}

		return null;
	}

}
