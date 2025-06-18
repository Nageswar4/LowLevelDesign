package com.snake.beans;



public class Board {
	private int ROW_COUNT;
	private int COL_COUNT;
	private Cell[][] board;

	public void intializeBoard(int count) {
		this.ROW_COUNT = count;
		this.COL_COUNT = count;

		this.board = new Cell[count][count];
		for (int row = 0; row < count; row++) {
			for (int col = 0; col < count; col++) {
				board[row][col] = new Cell(row, col);
			}
		}
	}

	public Cell[][] getBoard() {
		return this.board;
	}

	public void generateFood() {

		int row = 0;
		int col = 0;
		while (true) {

			row = (int) (Math.random() * ROW_COUNT);
			col = (int) (Math.random() * COL_COUNT);

			if (board[row][col].getCellType() == CellType.EMPTY)
				break;

		}
		board[row][col].setCellType(CellType.FOOD);

	}

}
