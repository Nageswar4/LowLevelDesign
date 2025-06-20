package com.chess.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chess.Board;
import com.chess.piece.Piece;

public class Player {
	private String playerId;
	private String playerName;
	private PieceType pieceType;
	private List<Move> movieList;
	private List<Piece> piecesList;

	public boolean makeMove(Board board, int fromRow, int fromCol, int toRow, int toCol) {

		Piece[][] pieces = board.getBoard();
		Piece piece = pieces[fromRow][fromCol];
		Piece captured = null;
		boolean result = piece.isValidMove(board, toRow, toCol);
		if (result) {
			pieces[fromRow][fromCol] = null;
			captured = pieces[toRow][toCol];
			pieces[toRow][toCol] = piece;
			Move move = new Move(piece, fromRow, fromCol, toRow, toCol, captured, LocalDate.now());
			if (captured != null) {
				this.piecesList.add(captured);
			}
			this.movieList.add(move);

			return true;

		}

		return false;

	}

	public String getPlayerId() {
		return playerId;
	}

	public Player(String playerId, String playerName, PieceType pieceType) {
		super();
		this.movieList = new ArrayList<>();
		this.piecesList = new ArrayList<>();
		this.playerId = playerId;
		this.playerName = playerName;
		this.pieceType = pieceType;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public List<Move> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Move> movieList) {
		this.movieList = movieList;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public PieceType getPieceType() {
		return pieceType;
	}

	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}

	public List<Piece> getPiecesList() {
		return piecesList;
	}

	public void setPiecesList(List<Piece> piecesList) {
		this.piecesList = piecesList;
	}

}
