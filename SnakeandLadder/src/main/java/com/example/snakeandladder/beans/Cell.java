package com.example.snakeandladder.beans;

public class Cell {

	private Jump jump;

	private final int row;
	private final int col;

	public Cell(int row, int col) {
		super();
		this.row = row;
		this.col = col;
		this.jump = null;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public Jump getJump() {
		return jump;
	}

	public void setJump(Jump jump) {
		this.jump = jump;
	}

}
