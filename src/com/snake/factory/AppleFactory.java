package com.snake.factory;

import com.snake.application.SnakeApplication;
import com.snake.application.SnakeApplication.GraphicMode;
import com.snake.character.element.Apple;
import com.snake.character.element.graphic.GraphicApple;
import com.snake.character.element.text.TextApple;

public class AppleFactory {

	public Apple createApple() {
		if(SnakeApplication.getGraphicMode() == GraphicMode.TEXT)
			return new TextApple();
		else
			return new GraphicApple();
	}
}
