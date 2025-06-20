package com.chess.piece;

import com.chess.Board;
import com.chess.beans.PieceType;

public class Queen extends Piece {

	public Queen(int row, int col, PieceType pieceType) {
		super(row, col, pieceType);
		
	}

	@Override
	public boolean isValidMove(Board board, int endRow, int endcol) {
		
		return false;
	}

}
