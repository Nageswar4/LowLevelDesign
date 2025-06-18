package com.snake.beans;

import java.util.Random;

import com.snake.direction.Direction;
import com.snake.direction.DirectionStrategy;

public class SnakeGame {

	private Snake snake;
	private Board board;
	private boolean isGameOver;
	private DirectionStrategy directionStrategy;

	public SnakeGame() {
		this.isGameOver = false;
		this.snake = new Snake();
		this.board = new Board();
		this.board.intializeBoard(10);
		this.snake.intializeSnake(new Cell(0, 0));
		this.directionStrategy = new DirectionStrategy();
		this.board.generateFood();
	}

	public void gameRunning() {

		while (!isGameOver) {

			int count = new Random().nextInt(1, 5);

			Direction dir = this.directionStrategy.getDirection(count);
			Cell[][] cells = board.getBoard();
			Cell nextCell = dir.getNextCell(snake.getHead(), cells);

			if (nextCell != null) {
				Cell newCell = cells[nextCell.getRow()][nextCell.getCol()];
				boolean result = snake.isMoveValid(newCell);
				if (!result) {
					isGameOver = true;
				} else {

					if (newCell.getCellType().equals(CellType.FOOD)) {
						snake.addFood(newCell);
						board.generateFood();
					} else {
						snake.moveNext(newCell);
					}
				}

			} else {
				this.isGameOver = true;
			}

		}

	}

}
