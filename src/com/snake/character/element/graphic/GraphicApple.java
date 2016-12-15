package com.snake.character.element.graphic;

import java.util.Random;

import com.snake.character.SnakeCharacter;
import com.snake.character.element.Apple;
import com.snake.character.element.SnakeElement;
import com.snake.character.graphic.GraphicSnakeCharacter;
import com.snake.math.Position2D;
import com.snake.world.World;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GraphicApple extends Apple {

	public GraphicApple() {
		element = new Circle(this.position.getX(), this.position.getY(), 8);
		element.setFill(Color.GREEN);
	}
	
	@Override
	public void setRandomPosition() {
		Random rand = new Random();
		
		SnakeCharacter snake = World.getWorld().getSnake();
		Bounds bounds = snake.getHead().getElement().getBoundsInParent();
		
		int x = 0;
		int y = 0;
		double width = bounds.getWidth() + GraphicSnakeCharacter.GRAHIC_SNAKE_SPACE;
		double height = bounds.getHeight() + GraphicSnakeCharacter.GRAHIC_SNAKE_SPACE;
		
		boolean correct = false;
		
		while(correct == false) {
			x = GraphicSnakeCharacter.GRAHIC_SNAKE_SPACE * rand.nextInt(20);
			y = GraphicSnakeCharacter.GRAHIC_SNAKE_SPACE * rand.nextInt(20);
			
			for(int i = 0; i < snake.getSnakeStructure().size(); i++) {
				SnakeElement snakeElement = snake.getSnakeStructure().get(i);
				if(snakeElement.getElement().getBoundsInParent().intersects(x, y, width, height) == true) {
					break;
				} else if(i == snake.getSnakeStructure().size() - 1 && snakeElement.getElement().getBoundsInParent().intersects(x, y, width, height) == false) {
					correct = true;
				}
			}
		}
		
		this.setPosition(new Position2D(x, y));
	}
}
