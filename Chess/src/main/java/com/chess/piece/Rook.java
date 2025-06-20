package com.chess.piece;

import com.chess.Board;
import com.chess.beans.PieceType;

public class Rook extends Piece {

	public Rook(int row, int col, PieceType pieceType) {
		super(row, col, pieceType);

	}

	@Override
	public boolean isValidMove(Board board, int endRow, int endCol) {
		if (this.row != endRow && this.col != endCol) {
			return false;
		}

		if (this.row == endRow) {
			// Move in same row — check columns in between
			int colStep = (endCol - this.col) > 0 ? 1 : -1;
			int currentCol = this.col + colStep;
			while (currentCol != endCol) {
				if (board.getBoard()[this.row][currentCol] != null) {
					return false; // blocked
				}
				currentCol += colStep;
			}
		} else {
			// Move in same column — check rows in between
			int rowStep = (endRow - this.row) > 0 ? 1 : -1;
			int currentRow = this.row + rowStep;
			while (currentRow != endRow) {
				if (board.getBoard()[currentRow][this.col] != null) {
					return false; // blocked
				}
				currentRow += rowStep;
			}
		}

		return true;
	}

}
