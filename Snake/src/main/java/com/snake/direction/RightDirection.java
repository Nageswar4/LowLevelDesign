package com.snake.direction;

import com.snake.beans.Cell;

public class RightDirection implements Direction {

	@Override
	public Cell getNextCell(Cell cell, Cell[][] board) {
		int col = cell.getCol();
		int row = cell.getRow();
		if (col + 1 < board[row].length) {
			return new Cell(row, col + 1);
		}

		return null;
	}
}
