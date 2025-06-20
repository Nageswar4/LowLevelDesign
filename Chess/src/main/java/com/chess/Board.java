package com.chess;

import com.chess.beans.PieceType;
import com.chess.factory.PieceFactory;
import com.chess.piece.King;
import com.chess.piece.Piece;

public class Board {

	private Piece[][] board;
	private PieceFactory pieceFactory;

	public void initialize(int count) {
		this.board = new Piece[count][count];
		pieceFactory = new PieceFactory();
		for (int i = 0; i < count; i++) {
			board[1][i] = this.pieceFactory.getPawn(1, i, PieceType.WHITE);
		}
		this.board[0][0] = this.pieceFactory.getRook(0, 0, PieceType.WHITE);
		this.board[0][1] = this.pieceFactory.getKnight(0, 1, PieceType.WHITE);
		this.board[0][2] = this.pieceFactory.getBishop(0, 2, PieceType.WHITE);
		this.board[0][3] = this.pieceFactory.getQueen(0, 3, PieceType.WHITE);
		this.board[0][4] = this.pieceFactory.getKing(0, 4, PieceType.WHITE);
		this.board[0][5] = this.pieceFactory.getBishop(0, 5, PieceType.WHITE);
		this.board[0][6] = this.pieceFactory.getKnight(0, 6, PieceType.WHITE);
		this.board[0][7] = this.pieceFactory.getRook(0, 7, PieceType.WHITE);

		for (int i = 0; i < count; i++) {
			board[6][i] = this.pieceFactory.getPawn(6, i, PieceType.BLACK);
		}
		this.board[7][0] = this.pieceFactory.getRook(7, 0, PieceType.BLACK);
		this.board[7][1] = this.pieceFactory.getKnight(7, 1, PieceType.BLACK);
		this.board[7][2] = this.pieceFactory.getBishop(7, 2, PieceType.BLACK);
		this.board[7][3] = this.pieceFactory.getQueen(7, 3, PieceType.BLACK);
		this.board[7][4] = this.pieceFactory.getKing(7, 4, PieceType.BLACK);
		this.board[7][5] = this.pieceFactory.getBishop(7, 5, PieceType.BLACK);
		this.board[7][6] = this.pieceFactory.getKnight(7, 6, PieceType.BLACK);
		this.board[7][7] = this.pieceFactory.getRook(7, 7, PieceType.BLACK);
	}

	public Piece[][] getBoard() {
		return board;
	}	
	public boolean isKingInCheck(PieceType player) {
        Piece king = findKing(player);
        if (king == null) return false; // should never happen

        int kingRow = king.getRow();
        int kingCol = king.getCol();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                Piece p = board[row][col];
                if (p != null && p.getPieceType() != player) {
                    if (p.isValidMove(this, kingRow, kingCol)) {
                        return true; // opponent can attack king
                    }
                }
            }
        }
        return false;
    }

    // ✅ Check if the player has any valid move at all
    public boolean hasAnyValidMove(PieceType player) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                Piece p = board[row][col];
                if (p != null && p.getPieceType() == player) {
                    // Try all squares for this piece
                    for (int newRow = 0; newRow < board.length; newRow++) {
                        for (int newCol = 0; newCol < board[newRow].length; newCol++) {
                            if (p.isValidMove(this, newRow, newCol)) {
                                // simulate move & see if king still in check
                                Piece oldPiece = board[newRow][newCol];
                                board[row][col] = null;
                                board[newRow][newCol] = p;

                                boolean kingInCheck = isKingInCheck(player);

                                // Undo move
                                board[row][col] = p;
                                board[newRow][newCol] = oldPiece;

                                if (!kingInCheck) {
                                    return true; // found at least one legal move
                                }
                            }
                        }
                    }
                }
            }
        }
        return false; // no legal moves
    }

    // ✅ Find king for the given player
    private Piece findKing(PieceType player) {
        for (Piece[] row : board) {
            for (Piece p : row) {
                if (p != null && p instanceof King && p.getPieceType() == player) {
                    return p;
                }
            }
        }
        return null;
    }

    // ✅ Final checks for Game class to use:
    public boolean isCheckMate(PieceType player) {
        return isKingInCheck(player) && !hasAnyValidMove(player);
    }

    public boolean isStaleMate(PieceType player) {
        return !isKingInCheck(player) && !hasAnyValidMove(player);
    }

}
