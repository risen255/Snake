package com.snake.character.element;

public abstract class SnakeElement extends Element {
	
	public enum ElementDirection {
		UP,
		DOWN,
		LEFT,
		RIGHT
	}
	
	protected ElementDirection direction;
	
	public ElementDirection getDirection() {
		return direction;
	}
	
	public void setDirection(ElementDirection direction) {
		this.direction = direction;
	}
}
