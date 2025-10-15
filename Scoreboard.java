package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Scoreboard extends Rectangle {
	int score = 0000000;

	public Scoreboard(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setWidth(200);
		this.setHeight(160);
		this.setFill(Color.TRANSPARENT);
	}

	public void draw(GraphicsContext g) {
		g.setFill(Color.BLACK);
		g.setFont(new Font("impact", 50));
		g.fillText(score+"", getX()+100, getY());
	}
}


