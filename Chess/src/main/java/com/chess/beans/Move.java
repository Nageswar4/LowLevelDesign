package com.chess.beans;

import java.time.LocalDate;

import com.chess.piece.Piece;

public class Move {

	private Piece piece;
	private int fromRow;
	private int fromCol;
	private int toRow;
	private int toCol;
	private Piece caputredPiece;
	private LocalDate localDate;

	public Move(Piece piece, int fromRow, int fromCol, int toRow, int toCol, Piece caputredPiece, LocalDate localDate) {
		super();
		this.piece = piece;
		this.fromRow = fromRow;
		this.fromCol = fromCol;
		this.toRow = toRow;
		this.toCol = toCol;
		this.caputredPiece = caputredPiece;
		this.localDate = localDate;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public int getFromRow() {
		return fromRow;
	}

	public void setFromRow(int fromRow) {
		this.fromRow = fromRow;
	}

	public int getFromCol() {
		return fromCol;
	}

	public void setFromCol(int fromCol) {
		this.fromCol = fromCol;
	}

	public int getToRow() {
		return toRow;
	}

	public void setToRow(int toRow) {
		this.toRow = toRow;
	}

	public int getToCol() {
		return toCol;
	}

	public void setToCol(int toCol) {
		this.toCol = toCol;
	}

	public Piece getCaputredPiece() {
		return caputredPiece;
	}

	public void setCaputredPiece(Piece caputredPiece) {
		this.caputredPiece = caputredPiece;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

}
