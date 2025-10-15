package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Dinosaur extends Rectangle{
	Image dinoImage = new Image("file:dino.png");
	
	public Dinosaur(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setWidth(70);
		this.setHeight(50);
		this.setFill(Color.TRANSPARENT);
	}

	public void draw(GraphicsContext g) {
		g.drawImage(dinoImage, getX(), getY(), getWidth(), getHeight());
		
	}
}
