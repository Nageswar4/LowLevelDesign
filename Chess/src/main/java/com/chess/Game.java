package com.chess;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import com.chess.beans.PieceType;
import com.chess.beans.Player;
import com.chess.piece.Piece;

public class Game {

	private static volatile Game game;
	private Board board;
	private Deque<Player> playerQueue;
	private boolean isGameOver = false;
	Scanner scanner = new Scanner(System.in);

	private Game() {
		this.board = new Board();
		this.playerQueue = new LinkedList<>();
		this.board.initialize(8);
		this.addPlayers();
	}

	private void addPlayers() {
		Player player1 = new Player("1", "White", PieceType.WHITE);
		Player player2 = new Player("2", "Black", PieceType.BLACK);
		this.playerQueue.add(player1);
		this.playerQueue.add(player2);

	}

	public static Game getInstance() {
		if (game == null) {
			synchronized (Game.class) {
				if (game == null) {
					game = new Game();
				}
			}
		}
		return game;
	}

	public boolean running() {

		while (!isGameOver) {
			Player playerTurn = this.playerQueue.poll();

			System.out.println("Please enter start Row Index");
			int startRow = scanner.nextInt();
			System.out.println("Please enter start  Column Index Index");
			int startCol = scanner.nextInt();
			System.out.println("Please enter End Row Index");
			int endRow = scanner.nextInt();
			System.out.println("Please enter End col Index");
			int endCol = scanner.nextInt();
			boolean isValidIndex = this.isMoveValid(startRow, startCol, endRow, endCol, playerTurn.getPieceType());
			if (isValidIndex) {
				boolean isMoveMade = playerTurn.makeMove(board, startRow, startCol, endRow, endCol);
				if (isMoveMade) {
					playerQueue.addLast(playerTurn);
				} else
					playerQueue.addFirst(playerTurn);
			}
			
			if (board.isCheckMate(playerTurn.getPieceType())) {
			    System.out.println(playerTurn.getPlayerName() + " is checkmated! Game Over.");
			    isGameOver = true;
			} else if (board.isStaleMate(playerTurn.getPieceType())) {
			    System.out.println("Game drawn by stalemate!");
			    isGameOver = true;
			}

		}

		return false;
	}

	private boolean isMoveValid(int startRow, int startCol, int endRow, int endCol, PieceType pieceType) {
		Piece[][] pieces = this.board.getBoard();
		if (startRow < 0 || startRow >= pieces.length || endRow < 0 || endRow >= pieces.length || startCol < 0
				|| startCol >= pieces[0].length || endCol < 0 || endCol >= pieces[0].length)
			return false;

		if (pieces[startRow][startCol] == null || pieces[startRow][startCol].getPieceType() != pieceType
				|| (pieces[endRow][endCol] != null
						&& pieces[startRow][startCol].getPieceType() == pieces[endRow][endCol].getPieceType()))
			return false;
		return true;
	}
}
