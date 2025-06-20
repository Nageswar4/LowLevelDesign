package com.chess.piece;

import com.chess.Board;
import com.chess.beans.PieceType;

public class Bishop extends Piece {

	public Bishop(int row, int col, PieceType pieceType) {
		super(row, col, pieceType);
	}

	@Override
	public boolean isValidMove(Board board, int endRow, int endCol) {
		Piece[][] pieces = board.getBoard();
		int rowDiff = Math.abs(this.row - endRow);
		int colDiff = Math.abs(this.col - endCol);
		if (rowDiff != colDiff)
			return false;
		int rowDirection = endRow - this.row > 0 ? 1 : -1;
		int colDirection = endCol - this.col > 0 ? 1 : -1;
		int currentRow = this.row + rowDirection;
		int currentCol = this.col + colDirection;
		while (currentRow != endRow && currentCol != endCol) {
			if (pieces[currentRow][currentCol] != null) {
				return false;
			}
			currentRow = currentRow + rowDirection;
			currentCol = currentCol + colDirection;
		}
		return true;
	}

}
