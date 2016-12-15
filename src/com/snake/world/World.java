package com.snake.world;

import java.util.ArrayList;
import java.util.List;

import com.snake.application.SnakeApplication;
import com.snake.application.SnakeApplication.GraphicMode;
import com.snake.character.SnakeCharacter;
import com.snake.character.element.Apple;
import com.snake.character.element.Element;
import com.snake.character.element.SnakeElement;
import com.snake.character.graphic.GraphicSnakeCharacter;
import com.snake.character.text.TextSnakeCharacter;
import com.snake.factory.AppleFactory;
import com.snake.factory.SnakeCharacterFactory;
import com.snake.math.Position2D;

import javafx.scene.layout.Pane;

public class World {

	private static World world = null;
	
	private Pane pane;
	
	private SnakeCharacterFactory snakeFactory;
	private AppleFactory applefactory;
	
	private SnakeCharacter snake;
	private List<Element> worldElements;
	
	private World() {
		pane = new Pane();
		
		snakeFactory = new SnakeCharacterFactory();
		applefactory = new AppleFactory();
		
		worldElements = new ArrayList<Element>();
	}
	
	public static World getWorld() {
		if(world == null)
			world = new World();
		
		return world;
	}
	
	public Pane getPane() {
		return pane;
	}
	public List<Element> getWorldElements() {
		return worldElements;
	}

	public void setWorldElements(List<Element> worldElements) {
		this.worldElements = worldElements;
	}
	
	public void initSnake() {
		snakeFactory = new SnakeCharacterFactory();
		snake = snakeFactory.createSnakeCharacter();
		
		snake.addTail();
		snake.addTail();
		snake.addTail();
		snake.addTail();
		snake.addTail();
		snake.addTail();
		snake.addTail();
		snake.addTail();
	}
	
	public SnakeCharacter getSnake() {
		return snake;
	}
	
	public void addApple() {
		Apple apple = applefactory.createApple();
		apple.setRandomPosition();
		
		worldElements.add(apple);
		pane.getChildren().add(apple.getElement());
	}
	
	public Apple getFirstApple() {
		World world = World.getWorld();
		for (Element element : world.getWorldElements()) {
			if(element instanceof Apple)
				return (Apple)element;
		}
		return null;
	}
}
