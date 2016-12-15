package com.snake.character.element.graphic;

import com.snake.character.element.SnakeHead;
import com.snake.character.graphic.GraphicSnakeCharacter;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GraphicSnakeHead extends SnakeHead {

	public GraphicSnakeHead() {
		element = new Circle(this.position.getX(), this.position.getY(), 8);
		element.setFill(Color.BLACK);
	}
	
	@Override
	public void moveUp() {
		this.setDirection(ElementDirection.DOWN);
		this.setPositionY(this.getPosition().getY() - GraphicSnakeCharacter.GRAHIC_SNAKE_SPACE);
	}

	@Override
	public void moveDown() {
		this.setDirection(ElementDirection.DOWN);
		this.setPositionY(this.getPosition().getY() + GraphicSnakeCharacter.GRAHIC_SNAKE_SPACE);
	}

	@Override
	public void moveLeft() {
		this.setDirection(ElementDirection.RIGHT);
		this.setPositionX(this.getPosition().getX() - GraphicSnakeCharacter.GRAHIC_SNAKE_SPACE);
	}

	@Override
	public void moveRight() {
		this.setDirection(ElementDirection.RIGHT);
		this.setPositionX(this.getPosition().getX() + GraphicSnakeCharacter.GRAHIC_SNAKE_SPACE);
	}
}
