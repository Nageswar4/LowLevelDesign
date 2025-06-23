package com.texteditor.beans;

public class Style {

	private FontName fontName;
	private int fontSize;
	private boolean isBold;
	private boolean isItalic;

	public FontName getFontName() {
		return fontName;
	}

	public void setFontName(FontName fontName) {
		this.fontName = fontName;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public Style(FontName fontName, int fontSize, boolean isBold, boolean isItalic) {
		super();
		this.fontName = fontName;
		this.fontSize = fontSize;
		this.isBold = isBold;
		this.isItalic = isItalic;
	}

	public boolean isBold() {
		return isBold;
	}

	public void setBold(boolean isBold) {
		this.isBold = isBold;
	}

	public boolean isItalic() {
		return isItalic;
	}

	public void setItalic(boolean isItalic) {
		this.isItalic = isItalic;
	}
}
