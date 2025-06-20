package com.chess.piece;

import com.chess.Board;
import com.chess.beans.PieceType;

public class King extends Piece {

	public King(int row, int col, PieceType pieceType) {
		super(row, col, pieceType);
	}

	@Override
	public boolean isValidMove(Board board, int endRow, int endCol) {
		int rowDiff = Math.abs(this.row - endRow);
		int colDiff = Math.abs(this.col - endCol);

		// Can move 1 step in any direction
		return rowDiff <= 1 && colDiff <= 1 && (rowDiff + colDiff) > 0;
	}

}
