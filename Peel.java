package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Peel extends Rectangle{
	static Image peelImage = new Image("file:peel.png");
	
	public Peel(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setWidth(35);
		this.setHeight(35);
		this.setFill(Color.TRANSPARENT);
	}

	public void draw(GraphicsContext g) {
		g.drawImage(peelImage, getX(), getY(), getWidth(), getHeight());
		
	}
}
