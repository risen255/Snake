package com.snake.scene;

import com.snake.keyboard.KeyboardEvent;
import com.snake.world.World;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class SnakeScene {
	
	private static SnakeScene snakeScene = null;
	
	private Scene scene;
	
	private SceneRender render;
	private Stage primaryStage;
	private World world;

	private SnakeScene() {
	}
	
	public void initSnakeScene(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		initObjects();
		initScene();
		initKeyboard();
	}
	
	private void initObjects() {
		
		world = World.getWorld();
		world.initSnake();
		
		world.addApple();
	}
	
	private void initScene() {
		scene = new Scene(world.getPane(), 800, 600);
		render = new SceneRender();
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Snake Game");
		primaryStage.show();
		
		render.start();
	}
	
	private void initKeyboard() {
		KeyboardEvent keyboard = new KeyboardEvent();
		render.setKeyboard(keyboard);
		
		scene.addEventHandler(KeyEvent.ANY, keyboard);
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public double getWidth() {
		return this.primaryStage.getWidth();
	}
	
	public double getHeight() {
		return this.primaryStage.getHeight();
	}

	public static SnakeScene getSnakeScene() {
		if(snakeScene == null)
			snakeScene = new SnakeScene();
		
		return snakeScene;
	}
}
