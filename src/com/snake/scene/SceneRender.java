package com.snake.scene;

import com.snake.character.element.Apple;
import com.snake.character.element.SnakeElement.ElementDirection;
import com.snake.cutscene.EatSelfCutScene;
import com.snake.keyboard.KeyboardEvent;
import com.snake.math.Position2D;
import com.snake.world.World;

import javafx.animation.AnimationTimer;

public class SceneRender extends AnimationTimer {

	private static final long SNAKE_MOVE_TIME = 100;

	private World world;
	private KeyboardEvent keyboard;

	private long currentTime = 0;

	public SceneRender() {
		world = World.getWorld();
	}

	public KeyboardEvent getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(KeyboardEvent keyboard) {
		this.keyboard = keyboard;
	}

	@Override
	public void handle(long time) {
		snakeMovementTick();
	}

	private void snakeMovementTick() {
		if (this.currentTime < System.currentTimeMillis()) {
			if (keyboard.isSnakeMovingEnabled() == true) {
				if (world.getSnake().isEatingSelf() == false) {
					if (keyboard.getKeyDirection() == ElementDirection.UP) {
						world.getSnake().moveUp();
					} else if (keyboard.getKeyDirection() == ElementDirection.DOWN) {
						world.getSnake().moveDown();
					} else if (keyboard.getKeyDirection() == ElementDirection.LEFT) {
						world.getSnake().moveLeft();
					} else if (keyboard.getKeyDirection() == ElementDirection.RIGHT) {
						world.getSnake().moveRight();
					}
					
					Apple apple = world.getSnake().getEatingApple();
					if (apple != null) {
						world.getSnake().addTail();
						apple.setRandomPosition();
					}
				} else {
					snakeEatEvent();
				}
			}

			currentTime = System.currentTimeMillis() + SceneRender.SNAKE_MOVE_TIME;
		}
	}

	private void snakeEatEvent() {
		keyboard.setSnakeMovingEnabled(false);

		EatSelfCutScene cutScene = new EatSelfCutScene(keyboard);
		cutScene.start();
	}
}
