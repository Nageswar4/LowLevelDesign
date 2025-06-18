package com.snake.direction;

import com.snake.beans.Cell;

public interface Direction {

	public abstract Cell getNextCell(Cell cell, Cell[][] board);
}
