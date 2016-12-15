package com.snake.character.graphic;

import java.util.LinkedList;
import java.util.Random;

import com.snake.character.SnakeCharacter;
import com.snake.character.element.SnakeElement;
import com.snake.character.element.SnakeElement.ElementDirection;
import com.snake.character.element.SnakeHead;
import com.snake.character.element.graphic.GraphicSnakeHead;
import com.snake.character.element.graphic.GraphicSnakeTail;
import com.snake.math.Position2D;
import com.snake.scene.SnakeScene;
import com.snake.world.World;

public class GraphicSnakeCharacter extends SnakeCharacter {
	
	public static final Integer GRAHIC_SNAKE_SPACE = 20;
	public static final Integer GRAPHIC_SNAKE_BESIDE_MAP = GRAHIC_SNAKE_SPACE;
	
	public GraphicSnakeCharacter() {
		this.snakeStructure = new LinkedList<SnakeElement>();
		addHead();
	}
	
	@Override
	public void addHead() {
		GraphicSnakeHead snakeHead = new GraphicSnakeHead();
		snakeHead.setDirection(ElementDirection.RIGHT);
		this.snakeStructure.add(0, snakeHead); // Put snake's head on the first place
		World.getWorld().getPane().getChildren().add(snakeHead.getElement());
	}

	@Override
	public void addTail() {
		SnakeElement lastElement = this.getLastElement();
		if(lastElement != null) {
			GraphicSnakeTail snakeTail = new GraphicSnakeTail();
			snakeTail.setDirection(lastElement.getDirection());
			
			ElementDirection direction = lastElement.getDirection();
			Position2D position = lastElement.getPosition();
			if(direction == ElementDirection.UP) {
				snakeTail.setPosition(position.getX(), position.getY() + GraphicSnakeCharacter.GRAHIC_SNAKE_SPACE);
			} else if(direction == ElementDirection.DOWN) {
				snakeTail.setPosition(position.getX(), position.getY() - GraphicSnakeCharacter.GRAHIC_SNAKE_SPACE);
			} else if(direction == ElementDirection.LEFT) {
				snakeTail.setPosition(position.getX() + GraphicSnakeCharacter.GRAHIC_SNAKE_SPACE, position.getY());
			} else if(direction == ElementDirection.RIGHT) {
				snakeTail.setPosition(position.getX() - GraphicSnakeCharacter.GRAHIC_SNAKE_SPACE, position.getY());
			}
			
			this.snakeStructure.add(snakeTail);
			World.getWorld().getPane().getChildren().add(snakeTail.getElement());
		}
	}
	
	@Override
	public void resetSnake() {
		Random rand = new Random();
		
		this.removeAllTails();
		this.getHead().setPosition(new Position2D(rand.nextInt(20) * GRAHIC_SNAKE_SPACE, rand.nextInt(20) * GRAHIC_SNAKE_SPACE));
		this.addTail();
		this.addTail();
	}
	
	@Override
	public boolean isHeadBesideMap() {
		SnakeHead head = this.getHead();
		if(head != null) {
			SnakeScene snakeScene = SnakeScene.getSnakeScene();
			
			int x = head.getPosition().getX();
			int y = head.getPosition().getY();
			
			if(x <= -GRAPHIC_SNAKE_BESIDE_MAP || x >= snakeScene.getWidth() ||
			   y <= -GRAPHIC_SNAKE_BESIDE_MAP || y >= snakeScene.getHeight() - GRAPHIC_SNAKE_BESIDE_MAP) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void setHeadOnOtherSide() {
		SnakeHead head = this.getHead();
		if(head != null) {
			
			SnakeScene snakeScene = SnakeScene.getSnakeScene();
			World world = World.getWorld();
			
			int x = head.getPosition().getX();
			int y = head.getPosition().getY();
			
			if(x <= -GRAPHIC_SNAKE_BESIDE_MAP) {
				world.getSnake().getHead().setPosition(new Position2D((int)snakeScene.getWidth(), y));
			} else if(x >= snakeScene.getWidth()) {
				world.getSnake().getHead().setPosition(new Position2D(-GRAPHIC_SNAKE_BESIDE_MAP, y));
			}
			
			if(y <= -GRAPHIC_SNAKE_BESIDE_MAP) {
				world.getSnake().getHead().setPosition(new Position2D(x, (int)snakeScene.getHeight() - GRAPHIC_SNAKE_BESIDE_MAP));
			} else if(y >= snakeScene.getHeight() - GRAPHIC_SNAKE_BESIDE_MAP) {
				world.getSnake().getHead().setPosition(new Position2D(x, -GRAPHIC_SNAKE_BESIDE_MAP));
			}
		}
	}
}
