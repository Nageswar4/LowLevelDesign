package com.texteditor.main;

import com.texteditor.beans.*;
import java.util.*;

public class TextEditor {

	private List<List<CharacterWithStyle>> document;

	public TextEditor() {
		this.document = new ArrayList<>();
	}

	public boolean addCharacter(int row, int col, char ch, String fontName, int fontSize, boolean isBold,
			boolean isItalic) {

		FontName font = FontName.fromValue(fontName);
		Style style = new Style(font, fontSize, isBold, isItalic);
		CharacterWithStyle characterWithStyle = new CharacterWithStyle(ch, style);

		while (document.size() <= row) {
			document.add(new ArrayList<>());
		}

		List<CharacterWithStyle> rowData = document.get(row);
		while (rowData.size() < col) {
			rowData.add(null);
		}
		if (rowData.size() == col) {
			rowData.add(characterWithStyle);
		} else {
			rowData.set(col, characterWithStyle);
		}
		return true;
	}

	public Style getStyle(int row, int col) {
		if (row < 0 || row >= document.size()) {
			throw new IndexOutOfBoundsException("Row out of range");
		}
		List<CharacterWithStyle> rowData = document.get(row);
		if (col < 0 || col >= rowData.size()) {
			throw new IndexOutOfBoundsException("Column out of range");
		}
		CharacterWithStyle characterData = rowData.get(col);
		return characterData.getStyle();
	}

	public Style deleteCharcater(int row, int col) {
		if (row < 0 || row >= document.size()) {
			throw new IndexOutOfBoundsException("Row out of range");
		}
		List<CharacterWithStyle> rowData = document.get(row);
		if (col < 0 || col >= rowData.size()) {
			throw new IndexOutOfBoundsException("Column out of range");
		}
		CharacterWithStyle characterData = rowData.get(col);
		rowData.remove(col);
		return characterData.getStyle();
	}

}
