package com.example.snakeandladder.beans;

import java.util.LinkedList;
import java.util.Queue;
public class Game {

	private static Game game;
	private Board board;
	private Dice dice;
	private Queue<Player> players;

	private boolean isGameDone = false;

	private Game() {
		this.board = new Board(10, 5, 5);
		this.dice = new Dice(1);
		this.players = new LinkedList<>();
		this.addPlayers();
	}

	private void addPlayers() {
		for (int i = 1; i <= 2; i++) {
			this.players.add(new Player("Player " + i));
		}
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

	public void start() {
		int boardSize = board.getCells().length * board.getCells().length;

		while (!isGameDone) {
			Player player = this.players.poll();

			int roll = this.dice.roll();
			int currentPosition = player.getPosition();
			int nextPosition = currentPosition + roll;

			if (nextPosition >= boardSize) {
				// Don't move, just requeue the player
				System.out.println(player.getPlayerName() + " rolled " + roll + " but can't move.");
			} else {
				Cell cell = getCell(nextPosition);
				if (cell.getJump() != null) {
					int jumpEnd = cell.getJump().getEnd();
					System.out.println(player.getPlayerName() + " hit a jump from " + nextPosition + " to " + jumpEnd);
					nextPosition = jumpEnd;
				}

				player.setPosition(nextPosition);
				System.out.println(player.getPlayerName() + " moved to " + nextPosition);

				if (nextPosition == boardSize - 1) {
					System.out.println("🎉 Winning Player is " + player.getPlayerName());
					isGameDone = true;
					break;
				}
			}

			this.players.add(player);
		}
	}

	private Cell getCell(int position) {
		int row = position / this.board.getCells().length;
		int col = position % this.board.getCells().length;
		return this.board.getCells()[row][col];
	}
}
