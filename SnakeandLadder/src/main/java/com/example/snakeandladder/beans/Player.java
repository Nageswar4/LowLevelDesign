package com.example.snakeandladder.beans;

public class Player {

	private final String playerName;

	private int position;

	public Player(String name) {
		this.playerName = name;
		this.position = 0;

	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int count) {
		this.position = count;
	}

	public String getPlayerName() {
		return playerName;
	}

}
