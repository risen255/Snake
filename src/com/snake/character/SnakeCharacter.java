package com.snake.character;

import java.util.LinkedList;

import com.snake.character.element.Apple;
import com.snake.character.element.Element;
import com.snake.character.element.SnakeElement;
import com.snake.character.element.SnakeElement.ElementDirection;
import com.snake.character.element.SnakeHead;
import com.snake.character.element.SnakeTail;
import com.snake.math.Position2D;
import com.snake.movement.Movement;
import com.snake.scene.SnakeScene;
import com.snake.world.World;

public abstract class SnakeCharacter implements Movement {

	protected LinkedList<SnakeElement> snakeStructure;

	public abstract void addHead();
	public abstract void addTail();
	public abstract void resetSnake();
	public abstract boolean isHeadBesideMap();
	public abstract void setHeadOnOtherSide();
	
	protected boolean movedStep = false;
	
	public LinkedList<SnakeElement> getSnakeStructure() {
		return snakeStructure;
	}

	public SnakeHead getHead() {
		return (SnakeHead) snakeStructure.get(0);
	}

	public SnakeTail getTail(int index) {
		return (SnakeTail) snakeStructure.get(index);
	}

	public SnakeTail getLastTail() {
		SnakeTail snakeTail = null;

		if (snakeStructure.size() >= 2) {
			snakeTail = (SnakeTail) snakeStructure.get(snakeStructure.size() - 1);
		}
		return snakeTail;
	}

	public SnakeElement getLastElement() {
		SnakeElement snakeElement = null;

		if (snakeStructure.size() > 0) {
			snakeElement = snakeStructure.get(snakeStructure.size() - 1);
		}
		return snakeElement;
	}
	
	public void removeLastTail() {
		SnakeTail snakeTail = this.getLastTail();
		if(snakeTail != null) {
			snakeStructure.remove(snakeTail);
			World.getWorld().getPane().getChildren().remove(snakeTail.getElement());
		}
	}
	
	public void removeAllTails() {
		if(snakeStructure.size() >= 2) {
			for(int i = snakeStructure.size() - 1; i >= 1; i--) {
				SnakeTail snakeTail = (SnakeTail)snakeStructure.remove(i);
				World.getWorld().getPane().getChildren().remove(snakeTail.getElement());
			}
		}
	}

	@Override
	public void moveUp() {
		this.move(ElementDirection.UP);
	}

	@Override
	public void moveDown() {
		this.move(ElementDirection.DOWN);
	}

	@Override
	public void moveLeft() {
		this.move(ElementDirection.LEFT);
	}

	@Override
	public void moveRight() {
		this.move(ElementDirection.RIGHT);
	}

	private void move(ElementDirection direction) {
		
		if(this.isHeadBesideMap() == true) {
			this.setHeadOnOtherSide();
		}

		SnakeHead head = this.getHead();
		Position2D previousPosition = head.getPosition();

		switch (direction) {
			case UP: {
				head.moveUp();
				break;
			}
			case DOWN: {
				head.moveDown();
				break;
			}
			case LEFT: {
				head.moveLeft();
				break;
			}
			case RIGHT: {
				head.moveRight();
				break;
			}
		}

		this.moveTail(previousPosition);
		this.setMovedStep(true);
	}
	
	private void moveTail(Position2D previousPosition) {
		for (int i = 1; i < snakeStructure.size(); i++) {
			SnakeTail currentTail = this.getTail(i);

			Position2D masz = previousPosition;
			previousPosition = currentTail.getPosition();
			currentTail.setPosition(masz);
		}
	}

	public Apple getEatingApple() {
		World world = World.getWorld();
		for (Element apple : world.getWorldElements()) {
			if (apple.getElement().getBoundsInParent().intersects(this.getHead().getElement().getBoundsInParent())) {
				return (Apple)apple;
			}
		}
		return null;
	}
	
	public boolean isEatingSelf() {
		for(int i = 1; i < snakeStructure.size(); i++) {
			SnakeTail snakeTail = (SnakeTail)snakeStructure.get(i);
			if(snakeTail.getElement().getBoundsInParent().intersects(this.getHead().getElement().getBoundsInParent())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isMovedStep() {
		return movedStep;
	}
	
	public void setMovedStep(boolean movedStep) {
		this.movedStep = movedStep;
	}
}
