package com.texteditor.beans;

public class CharacterWithStyle {

	private char charcater;
	private Style style;

	public char getCharcater() {
		return charcater;
	}

	public void setCharcater(char charcater) {
		this.charcater = charcater;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public CharacterWithStyle(char charcater, Style style) {
		super();
		this.charcater = charcater;
		this.style = style;
	}

}
