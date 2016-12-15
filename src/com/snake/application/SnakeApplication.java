package com.snake.application;

import com.snake.scene.SnakeScene;

import javafx.application.Application;
import javafx.stage.Stage;

public class SnakeApplication extends Application {
	
	public enum GraphicMode {
		TEXT,
		GRAPHIC
	};
	
	public static GraphicMode SNAKE_GRAPHIC_MODE = GraphicMode.GRAPHIC;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		SnakeScene.getSnakeScene().initSnakeScene(primaryStage);
	}
	
	public static GraphicMode getGraphicMode() {
		return SNAKE_GRAPHIC_MODE;
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
