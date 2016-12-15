package com.snake.character.element;

import com.snake.math.Position2D;

import javafx.scene.shape.Shape;

public abstract class Element {

	protected Shape element;
	protected Position2D position = new Position2D();
	
	public Shape getElement() {
		return element;
	}
	
	public void setPosition(Position2D position) {
		
		Position2D pos = new Position2D(position.getX(), position.getY());
		this.position = pos;
		
		translatePosition();
	}
	
	public void setPosition(int x, int y) {
		
		Position2D position = new Position2D(x, y);
		this.position = position;
		
		translatePosition();
	}
	
	public void setPositionX(int x) {
		
		Position2D position = new Position2D(x, this.position.getY());
		this.position = position;
		
		translatePosition();
	}
	
	public void setPositionY(int y) {
		Position2D position = new Position2D(this.position.getX(), y);
		this.position = position;
		
		translatePosition();
	}
	
	public Position2D getPosition() {
		return position;
	}
	
	private void translatePosition() {
		element.setTranslateX(this.position.getX());
		element.setTranslateY(this.position.getY());
	}
}
