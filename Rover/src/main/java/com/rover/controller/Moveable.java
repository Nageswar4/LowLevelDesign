package com.rover.controller;

public abstract class Moveable {

	protected int row;
	protected int col;

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public abstract boolean isValid(int start, int end, int newStart, int newEnd);
}
