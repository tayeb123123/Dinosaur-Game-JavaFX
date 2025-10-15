package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameOver extends Rectangle{
	static Image gameoverImage = new Image("file:gameover.png");
	
	public GameOver(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setWidth(200);
		this.setHeight(160);
		this.setFill(Color.TRANSPARENT);
	}

	public void draw(GraphicsContext g) {
		g.drawImage(gameoverImage, getX(), getY(), getWidth(), getHeight());
		
	}
}
