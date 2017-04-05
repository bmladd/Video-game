package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class SwitchingScenes extends Application {

	AnimationTimer Gamer;
	private static int Movement = 1;
	public Stage window;
	public Scene scene1, scene2, scene3;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primarystage) throws Exception {
		window = primarystage;

		// Images
		Image space = new Image("file:testing/Courtyard.png");
		Image space2 = new Image("file:testing/Mountain.png");
		Image TitleScreen = new Image("file:testing/TitleScreen.png");

		// Button1Copy
		Button BC = new Button("Quit");
		BC.setLayoutX(0);
		BC.setLayoutY(0);
		BC.setOnAction(e -> {
			
		window.setScene(scene2);
		
		});
		// Layout for animation:
		Group root = new Group();
		scene1 = new Scene(root);
		primarystage.setScene(scene1);
		Canvas canvas = new Canvas(1024, 768);
		root.getChildren().add(canvas);
		root.getChildren().add(BC);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		// Animation Timer:
		Image hero = new Image("file:testing/hero.png", 50, 64, true, false);
		Image Enemy = new Image("file:testing/enemya.png");
		final long startNanoTime = System.nanoTime();

		ArrayList<String> input = new ArrayList<String>();

		scene1.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				String code = e.getCode().toString();

				// only add once... prevent duplicates
				if (!input.contains(code))
					input.add(code);
			}
		});

		scene1.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				String code = e.getCode().toString();
				input.remove(code);
			}
		});

		boolean[] KeyLast = { false, false, false, false };
		String[] Keys = { "W", "A", "S", "D", "E" };

		int[] position = { 24, 24 };
		Gamer = new AnimationTimer() {
			public void handle(long currentNanoTime) {
				double t = (currentNanoTime - startNanoTime) / 1000000000.0;

				gc.clearRect(0, 0, 1024, 768);
				gc.drawImage(space, 0, 0);

				// going up
				if (input.contains(Keys[0])) {
					if (KeyLast[0] && (position[1] != 24)) {
						position[1] = position[1] - Movement;
					} else {
						KeyLast[0] = true;

					}

				} else {
					KeyLast[0] = false;
				}
				// going left
				if (input.contains(Keys[1])) {
					if ((KeyLast[1] && (position[0] != 24))) {

						position[0] = position[0] - Movement;

					} else {
						KeyLast[1] = true;

					}

				} else {
					KeyLast[1] = false;
				}
				// going down
				if (input.contains(Keys[2])) {
					if (KeyLast[2] && (position[1] != 680)) {
						position[1] = position[1] + Movement;
					} else {
						KeyLast[2] = true;

					}

				} else {
					KeyLast[2] = false;
				}
				// going right
				if (input.contains(Keys[3])) {
					if (KeyLast[3] && (position[0] != 949)) {

						position[0] = position[0] + Movement;

					} else {
						KeyLast[3] = true;

					}

				} else {
					KeyLast[3] = false;
				}

				gc.drawImage(hero, position[0], position[1]);

				// clear the canvas
				// Background image clears canvas

			}
		};
		//

		// Button1
		Button B = new Button("Quit");
		B.setLayoutX(0);
		B.setLayoutY(0);
		B.setOnAction(e -> window.setScene(scene2));
		

		// Button3
		Button B3 = new Button("Options");
		B3.setLayoutX(430);
		B3.setLayoutY(580);
		B3.setPrefSize(160, 60);
		B3.setOnAction(e -> window.setScene(scene3));
		// Button2
		Button B2 = new Button("Play");
		B2.setLayoutX(430);
		B2.setLayoutY(500);
		B2.setPrefSize(160, 60);
		B2.setOnAction(e -> {

			window.setScene(scene1);
			Gamer.start();

		});

		// Big Main Game Start//

		// Big Main Game End//

		// Layout3
		Group root3 = new Group();
		Canvas canvas3 = new Canvas(1024, 768);
		root3.getChildren().add(canvas3);
		root3.getChildren().add(B3);
		root3.getChildren().add(B);
		GraphicsContext gc3 = canvas3.getGraphicsContext2D();
		gc3.drawImage(space2, 0, 0);
		scene3 = new Scene(root3);

		// Layout2
		Group root2 = new Group();
		Canvas canvas2 = new Canvas(1024, 768);
		root2.getChildren().add(canvas2);
		root2.getChildren().add(B2);
		root2.getChildren().add(B3);
		GraphicsContext gc2 = canvas2.getGraphicsContext2D();
		gc2.drawImage(TitleScreen, 0, 0);
		scene2 = new Scene(root2);

		// end stuff

		window.setScene(scene2);
		window.setTitle("Welcome!");
		window.show();
	}

}