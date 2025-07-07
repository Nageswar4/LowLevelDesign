package com.example.snakeandladder.beans;

import java.util.Random;

public class Board {

	private Cell[][] board;
	Random random = new Random();

	public Board(int length, int snakes, int ladder) {

		this.board = new Cell[length][length];

		this.intializeBoard(length);
		this.intializeSnakeAndLadder(snakes, ladder);

	}

	private void intializeSnakeAndLadder(int snakes, int ladder) {
		while (snakes > 0) {
			Jump jump = getJump();
			if (jump.getStart() < jump.getEnd() || jump.getStart() == jump.getEnd()) {
				continue;
			}
			Cell cell = getCell(jump.getStart());
			if (cell.getJump() != null)
				continue;
			cell.setJump(jump);
			snakes--;
		}
		while (ladder > 0) {
			Jump jump = getJump();
			if (jump.getStart() > jump.getEnd() || jump.getStart() == jump.getEnd()) {
				continue;
			}
			Cell cell = getCell(jump.getStart());
			if (cell.getJump() != null)
				continue;
			cell.setJump(jump);
			ladder--;
		}
	}

	private Cell getCell(int start) {

		int row = start / board.length;
		int col = start % board.length;

		return board[row][col];
	}

	private Jump getJump() {
		int size = board.length * board.length;
		int start = random.nextInt(size);
		int end = random.nextInt(size);
		return new Jump(start, end);
	}

	private void intializeBoard(int length) {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				board[i][j] = new Cell(i, j);
			}
		}

	}

	public Cell[][] getCells() {
		return this.board;
	}

}
