package application;

import java.io.File;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class DinosaurGame extends Application {
	// speed for dinosaur and map
	double speed = 0;
	double mapspeed = 5;

	// ticks for mapspeed and score
	int mapspeedtick = 0;
	int scoretick = 0;

	int score = 0;
	boolean gameover = false;

	// timers for animations
	AnimationTimer t;

	// scoreboard object to display
	Scoreboard sb = new Scoreboard(1400, 50);

	@Override
	public void start(Stage stage) {
		Random rng = new Random();
		Pane root = new Pane();
		Pane root2 = new Pane();
		Scene s = new Scene(root, 1600, 600);
		Scene gameOver = new Scene(root2, 1600, 600);

		// creates new canvas
		Canvas c = new Canvas(1600, 600);

		GraphicsContext g = c.getGraphicsContext2D();

		// adds to canvas
		root.getChildren().add(c);

		// creates dinosaur object to display
		Dinosaur d = new Dinosaur(200, 355);

		// two arrays to store peels and floors
		ArrayList<Peel> peels = new ArrayList<Peel>();
		ArrayList<Floor> floors = new ArrayList<Floor>();

		// creates a jump sound
		Media sound = new Media(new File("jump.mp3").toURI().toString());

		// loops 10000 times
		for (int i = 0; i < 10000; i++) {
			// randomly generates a number between 500 and 1600
			int random = rng.nextInt(1100) + 500;

			// creates 2 new peels each loop
			Peel p1 = new Peel(1380, 370);
			Peel p2 = new Peel(1700 + random * i, 370);

			// creates 2 new floors each loop
			Floor f1 = new Floor(0 + 400 * i, 400);
			Floor f2 = new Floor(0 + 800 * i, 400);

			// adds 2 peels to the array
			peels.add(p1);
			peels.add(p2);

			// adds 2 floors to the array
			floors.add(f1);
			floors.add(f2);
		}

		// does the if statement if key pressed
		s.setOnKeyPressed(event -> {

			// if dinosaur height is equal to floor
			if (d.getY() == 355) {

				// jump height of dinosaur
				speed = 13.0;

				// moves the dinosaur
				d.setY(d.getY() - speed);

				MediaPlayer mediaPlayer = new MediaPlayer(sound);

				// plays the sound
				mediaPlayer.play();

			}

		});

		// first animation timer
		t = new AnimationTimer() {
			@Override
			public void handle(long now) {
				// erase screen
				g.clearRect(0, 0, 1600, 600);

				// dinosaur and scoreboard
				d.draw(g);
				sb.draw(g);

				// sets the displayed score equal to the score field
				sb.score = score;

				// loops
				for (int i = 0; i < peels.size(); i++) {
					// draws the peels
					peels.get(i).draw(g);

					// check for peel and dinosaur collision
					if (d.intersects(peels.get(i).getBoundsInParent())) {
						// sets gameover to true
						gameover = true;
					}

					// move peels left
					peels.get(i).setX(peels.get(i).getX() - mapspeed);
				}

				// loops
				for (int i = 0; i < floors.size(); i++) {
					// draws the floor
					floors.get(i).draw(g);

					// moves floors left
					floors.get(i).setX(floors.get(i).getX() - mapspeed);
				}

				// adds 1 to mapspeed and score ticks
				mapspeedtick++;
				scoretick++;

				// adds to score if scoretick reaches over 16
				while (scoretick > 16) {

					// adds to score
					score++;

					// resets scoretick
					scoretick = 0;

				}

				// gravity
				speed -= 0.6;

				if (d.getY() < 355) {
					// change position
					d.setY(d.getY() - speed);
				}

				// if dinosaur goes below the floor
				else if (d.getY() > 355) {
					// changes y position of dinosaur
					d.setY(355);
				}

				// do nothing
				else {

				}

				// adds to mapspeed, capping at 20 speed
				while (mapspeedtick > 300 && mapspeed < 20) {
					// adds to mapspeed
					mapspeed++;
					// resets mapspeedtick 
					mapspeedtick = 0;
				}

				if (gameover == true) {
					// ends animation timer if gameover is set to true
					t.stop();

					// creates a new canvas
					Canvas c2 = new Canvas(1600, 600);

					GraphicsContext g2 = c2.getGraphicsContext2D();

					// adds to canvas
					root2.getChildren().add(c2);

					// creates gameover image
					GameOver go = new GameOver(700, 200);

					// sets the x and y of scoreboard
					sb.setX(675);
					sb.setY(400);

					// draws gameover and scoreboard
					sb.draw(g2);
					go.draw(g2);

					// sets the scene to the gameover canvas
					stage.setScene(gameOver);

					// changes name
					stage.setTitle("Game Over");

				}

			}

		};

		// starts animation timer
		t.start();

		// sets scene to s
		stage.setScene(s);

		stage.show();

		// sets title
		stage.setTitle("Dinosaur Game");

	}

	public static void main(String[] args) {
		launch(args);
	}
}
