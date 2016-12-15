package com.snake.character.element.text;

import java.util.Random;

import com.snake.character.SnakeCharacter;
import com.snake.character.element.Apple;
import com.snake.character.element.SnakeElement;
import com.snake.character.text.TextSnakeCharacter;
import com.snake.math.Position2D;
import com.snake.world.World;

import javafx.geometry.Bounds;
import javafx.scene.text.Text;

public class TextApple extends Apple {

	public TextApple() {
		element = new Text(this.position.getX(), this.position.getY(), "A");
	}

	@Override
	public void setRandomPosition() {
		Random rand = new Random();

		SnakeCharacter snake = World.getWorld().getSnake();
		Bounds bounds = snake.getHead().getElement().getBoundsInParent();

		int x = 0;
		int y = 0;
		double width = bounds.getWidth() + (TextSnakeCharacter.TEXT_SNAKE_SPACE * 3);
		double height = bounds.getHeight() + (TextSnakeCharacter.TEXT_SNAKE_SPACE * 3);
		
		boolean correct = false;

		while (correct == false) {
			x = TextSnakeCharacter.TEXT_SNAKE_SPACE * rand.nextInt(20);
			y = TextSnakeCharacter.TEXT_SNAKE_SPACE * rand.nextInt(20);

			for (int i = 0; i < snake.getSnakeStructure().size(); i++) {
				SnakeElement snakeElement = snake.getSnakeStructure().get(i);
				if (snakeElement.getElement().getBoundsInParent().intersects(x, y, width, height) == true) {
					break;
				} else if (i == snake.getSnakeStructure().size() - 1 && snakeElement.getElement().getBoundsInParent().intersects(x, y, width, height) == false) {
					correct = true;
				}
			}
		}

		this.setPosition(new Position2D(x, y));
	}
}
