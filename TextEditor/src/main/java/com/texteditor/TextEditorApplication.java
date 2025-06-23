package com.texteditor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.texteditor.beans.FontName;
import com.texteditor.main.TextEditor;

@SpringBootApplication
public class TextEditorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TextEditorApplication.class, args);
	}

	@Bean
	public CommandLineRunner onRun() {
		return args -> {

			TextEditor editor = new TextEditor();
			editor.addCharacter(0, 0, 'N', FontName.Catheline.getValue(), 4, false, false);
			editor.addCharacter(0, 1, 'a', FontName.Catheline.getValue(), 4, false, false);
			editor.addCharacter(0, 2, 'g', FontName.Catheline.getValue(), 4, false, false);
			editor.addCharacter(0, 3, 'e', FontName.Catheline.getValue(), 4, false, false);
			editor.addCharacter(0, 4, 's', FontName.Catheline.getValue(), 4, false, false);
			editor.addCharacter(0, 5, 'w', FontName.Catheline.getValue(), 4, false, false);
			editor.addCharacter(0, 6, 'a', FontName.Catheline.getValue(), 4, false, false);
			editor.deleteCharcater(0, 4);
			editor.print();
			// editor.delete(0, 6, 'w', FontName.Catheline.getValue(), 4, false, false);

		};
	}

}
