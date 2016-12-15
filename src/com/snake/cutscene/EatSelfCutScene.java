package com.snake.cutscene;

import com.snake.character.element.Apple;
import com.snake.factory.EatSelfCutSceneFactory;
import com.snake.keyboard.KeyboardEvent;
import com.snake.scene.SnakeScene;
import com.snake.world.World;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class EatSelfCutScene implements EventHandler<ActionEvent> {

	private static final Integer AFTER_COUNTDOWN = -1;
	
	private Text text;
	private Timeline timeline;
	
	private World world;
	private KeyboardEvent keyboard;

	private int timeSeconds = 5;
	
	public EatSelfCutScene(KeyboardEvent keyboard) {
		
		this.keyboard = keyboard;
		this.world = World.getWorld();
		
		SnakeScene snakeScene = SnakeScene.getSnakeScene();
		EatSelfCutSceneFactory factory = new EatSelfCutSceneFactory();
		text = factory.createText((int)(snakeScene.getWidth() / 2) - 150, (int)(snakeScene.getHeight() / 2), "Ugryzles samego siebie!");

		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), this));
	}

	@Override
	public void handle(ActionEvent arg0) {
		if(timeSeconds > 0) {
			timeRemain();
		} else if(timeSeconds == 0) {
			restartGame();
		} else if(timeSeconds == AFTER_COUNTDOWN) {
			World.getWorld().getPane().getChildren().remove(text);
			timeline.stop();
		}
		
		timeSeconds--;
	}
	
	private void timeRemain() {
		text.setText("Do rozpoczecia pozostalo: " + timeSeconds);
	}
	
	private void restartGame() {
		world.getSnake().resetSnake();
		
		Apple apple = world.getFirstApple();
		if(apple != null)
			apple.setRandomPosition();
		
		keyboard.setSnakeMovingEnabled(true);
		keyboard.setKeyDirection(World.getWorld().getSnake().getHead().getDirection());
		
		text.setText("Mo¿esz juz rozpocz¹æ gre!");
	}
	
	public void start() {
		World.getWorld().getPane().getChildren().add(text);
		timeline.playFromStart();
	}
}
