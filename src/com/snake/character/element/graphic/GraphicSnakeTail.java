package com.snake.character.element.graphic;


import com.snake.character.element.SnakeTail;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GraphicSnakeTail extends SnakeTail {

	public GraphicSnakeTail() {
		element = new Circle(this.position.getX(), this.position.getY(), 8);
		element.setFill(Color.RED);
	}
}
