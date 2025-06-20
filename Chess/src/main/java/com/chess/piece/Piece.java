package com.chess.piece;

import com.chess.Board;
import com.chess.beans.PieceType;

public abstract class Piece {

	protected int row;
	protected int col;
	protected PieceType pieceType;

	public Piece(int row, int col, PieceType pieceType) {
		super();
		this.row = row;
		this.col = col;
		this.pieceType = pieceType;
	}

	public abstract boolean isValidMove(Board board, int endRow, int endcol);

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

	public PieceType getPieceType() {
		return pieceType;
	}

	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}

}
