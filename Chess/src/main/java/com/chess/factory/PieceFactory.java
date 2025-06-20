package com.chess.factory;

import com.chess.beans.PieceType;
import com.chess.piece.Bishop;
import com.chess.piece.King;
import com.chess.piece.Knight;
import com.chess.piece.Pawn;
import com.chess.piece.Piece;
import com.chess.piece.Queen;
import com.chess.piece.Rook;

public class PieceFactory {

	public Piece getBishop(int row, int col, PieceType type) {
		return new Bishop(row, col, type);
	}

	public Piece getRook(int row, int col, PieceType type) {
		return new Rook(row, col, type);
	}

	public Piece getPawn(int row, int col, PieceType type) {
		return new Pawn(row, col, type);
	}
	public Piece getKnight(int row, int col, PieceType type) {
		return new Knight(row, col, type);
	}
	public Piece getKing(int row, int col, PieceType type) {
		return new King(row, col, type);
	}
	public Piece getQueen(int row, int col, PieceType type) {
		return new Queen(row, col, type);
	}

}
