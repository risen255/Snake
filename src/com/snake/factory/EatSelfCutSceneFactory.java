package com.snake.factory;

import com.snake.application.SnakeApplication;
import com.snake.application.SnakeApplication.GraphicMode;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EatSelfCutSceneFactory {

	public Text createText(int x, int y, String text) {
		if (SnakeApplication.getGraphicMode() == GraphicMode.TEXT) {
			return new Text(x, y, text);
		} else {
			Text graphicText = new Text(x, y, text);
			graphicText.setFont(Font.font ("Verdana", 20));
			graphicText.setFill(Color.GREEN);
			return graphicText;
		}
	}
}
