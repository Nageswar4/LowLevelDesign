package com.texteditor.beans;

public enum FontSize {

	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7);

	int value;

	FontSize(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public static int getValue(int value) {
		for (FontSize size : FontSize.values()) {
			if (value == size.getValue())
				return size.getValue();
		}
		return value;
	}

}
