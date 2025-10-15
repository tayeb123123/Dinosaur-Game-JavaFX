package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Floor extends Rectangle {
	static Image floorImage = new Image("file:floor.png");

	public Floor(double x, double y) {
		setX(x);
		setY(y);
		setWidth(400);
		setHeight(350);
		setFill(Color.TRANSPARENT);
	}
	
	public void draw(GraphicsContext g) {
		g.drawImage(floorImage, getX(), getY(), getWidth(), getHeight());
	}
}

