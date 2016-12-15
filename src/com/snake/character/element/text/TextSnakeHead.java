package com.snake.character.element.text;

import com.snake.character.element.SnakeHead;
import com.snake.character.text.TextSnakeCharacter;

import javafx.scene.text.Text;

public class TextSnakeHead extends SnakeHead {

	public TextSnakeHead() {
		element = new Text(this.position.getX(), this.position.getY(), "H");
	}
	
	@Override
	public void moveUp() {
		this.setDirection(ElementDirection.DOWN);
		this.setPositionY(this.getPosition().getY() - TextSnakeCharacter.TEXT_SNAKE_SPACE);
	}

	@Override
	public void moveDown() {
		this.setDirection(ElementDirection.DOWN);
		this.setPositionY(this.getPosition().getY() + TextSnakeCharacter.TEXT_SNAKE_SPACE);
	}

	@Override
	public void moveLeft() {
		this.setDirection(ElementDirection.RIGHT);
		this.setPositionX(this.getPosition().getX() - TextSnakeCharacter.TEXT_SNAKE_SPACE);
	}

	@Override
	public void moveRight() {
		this.setDirection(ElementDirection.RIGHT);
		this.setPositionX(this.getPosition().getX() + TextSnakeCharacter.TEXT_SNAKE_SPACE);
	}
}
