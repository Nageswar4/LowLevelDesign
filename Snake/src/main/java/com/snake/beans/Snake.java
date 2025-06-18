package com.snake.beans;

import java.util.LinkedList;

public class Snake {

	private Cell head;
	LinkedList<Cell> snakeLinkedList;

	public void intializeSnake(Cell initialPosition) {
		this.snakeLinkedList = new LinkedList<>();
		this.head = initialPosition;
		this.head.setCellType(CellType.SNAKE_NODE);
		this.addFirst(this.head);

	}

	public void addFirst(Cell cell) {
		this.snakeLinkedList.addFirst(cell);
	}

	public void addFood(Cell cell) {
		cell.setCellType(CellType.SNAKE_NODE);
		this.head = cell;
		this.snakeLinkedList.addFirst(cell);
	}

	public void moveNext(Cell cell) {
		this.head = cell;
		this.head.setCellType(CellType.SNAKE_NODE);
		this.addFirst(this.head);
		Cell lastCell = this.snakeLinkedList.removeLast();
		lastCell.setCellType(CellType.EMPTY);
	}

	public LinkedList<Cell> getSnakeList() {
		return this.snakeLinkedList;
	}

	public Cell getHead() {
		return this.head;
	}

	public boolean isMoveValid(Cell newCell) {

		if (newCell.getCellType().equals(CellType.SNAKE_NODE))
			return false;

		return true;

	}

}
