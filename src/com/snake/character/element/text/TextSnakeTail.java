package com.snake.character.element.text;

import com.snake.character.element.SnakeTail;

import javafx.scene.text.Text;

public class TextSnakeTail extends SnakeTail {

	public TextSnakeTail() {
		element = new Text(this.position.getX(), this.position.getY(), "T");
	}
}
