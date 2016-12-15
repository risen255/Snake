package com.snake.keyboard;

import com.snake.character.SnakeCharacter;
import com.snake.character.element.SnakeElement.ElementDirection;
import com.snake.world.World;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardEvent implements EventHandler<KeyEvent> {

	private ElementDirection keyDirection = ElementDirection.RIGHT;
	
	private boolean snakeMovingEnabled = true;
	
	public KeyboardEvent() {
	}
	
	@Override
	public void handle(KeyEvent event) {
		if(event.getEventType() == KeyEvent.KEY_PRESSED)
			keyPressed(event);
		else if(event.getEventType() == KeyEvent.KEY_RELEASED) {
			keyReleased(event);
		}
	}
	
	private void keyPressed(KeyEvent event) {
		
		SnakeCharacter snake = World.getWorld().getSnake();
		
		if(event.getCode() == KeyCode.W) {
			if(keyDirection != ElementDirection.DOWN && snake.isMovedStep() == true) {
				keyDirection = ElementDirection.UP;
				snake.setMovedStep(false);
			}
		} else if(event.getCode() == KeyCode.S) {
			if(keyDirection != ElementDirection.UP && snake.isMovedStep() == true) {
				keyDirection = ElementDirection.DOWN;
				snake.setMovedStep(false);
			}
		} else if(event.getCode() == KeyCode.A) {
			if(keyDirection != ElementDirection.RIGHT && snake.isMovedStep() == true) {
				keyDirection = ElementDirection.LEFT;
				snake.setMovedStep(false);
			}
		} else if(event.getCode() == KeyCode.D) {
			if(keyDirection != ElementDirection.LEFT && snake.isMovedStep() == true) {
				keyDirection = ElementDirection.RIGHT;
				snake.setMovedStep(false);
			}
		}
	}
	
	private void keyReleased(KeyEvent event) {
	}
	
	public ElementDirection getKeyDirection() {
		return keyDirection;
	}
	
	public void setKeyDirection(ElementDirection direction) {
		this.keyDirection = direction;
	}

	public boolean isSnakeMovingEnabled() {
		return snakeMovingEnabled;
	}

	public void setSnakeMovingEnabled(boolean snakeMovingEnabled) {
		this.snakeMovingEnabled = snakeMovingEnabled;
	}
	
}
