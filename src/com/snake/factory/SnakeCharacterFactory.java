package com.snake.factory;

import com.snake.application.SnakeApplication;
import com.snake.application.SnakeApplication.GraphicMode;
import com.snake.character.SnakeCharacter;
import com.snake.character.graphic.GraphicSnakeCharacter;
import com.snake.character.text.TextSnakeCharacter;

public class SnakeCharacterFactory {

	public SnakeCharacter createSnakeCharacter() {
		if (SnakeApplication.getGraphicMode() == GraphicMode.TEXT)
			return new TextSnakeCharacter();
		else
			return new GraphicSnakeCharacter();
	}
}
