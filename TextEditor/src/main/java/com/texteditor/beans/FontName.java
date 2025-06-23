package com.texteditor.beans;

public enum FontName {

	Normal("Normal"), Catheline("Catheline"), Areial("Aerial");

	private String name;

	FontName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.name;
	}

	public static FontName fromValue(String value) {
		for (FontName fontName : FontName.values()) {
			if (fontName.getValue().equalsIgnoreCase(value)) {
				return fontName;
			}
		}
		throw new IllegalArgumentException("No FontName with value " + value);
	}

}
