package application;

import java.util.ArrayList;

import charactersAndObjects.BackgroundObject;
import charactersAndObjects.MovableObject;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import levelConstants.Constants;

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

		// Maps
		BackgroundObject Courtyard = new BackgroundObject(Constants.Courtyard);
		Courtyard.addCollisionBoxes(Constants.getCourtyardCollisions());
		Courtyard.addDoors(Constants.getCourtyardDoors());

		BackgroundObject Mountain = new BackgroundObject(Constants.Mountain);

		BackgroundObject ForestLake = new BackgroundObject(Constants.ForestLake);
		ForestLake.addCollisionBoxes(Constants.getForestLakeCollisions());
		ForestLake.addDoors(Constants.getForestLakeDoors());

		BackgroundObject Temple = new BackgroundObject(Constants.Temple);

		BackgroundObject Options = new BackgroundObject(Constants.Options);

		BackgroundObject TitleScreen = new BackgroundObject(Constants.TitleScreen);


		//Maps
		Image hero = new Image("file:JavaFXGameCharacters/heroflip.png", 50, 64, true, false);
		MovableObject playerCharacter = new MovableObject(24, 24, hero);

		Image heroflip = new Image("file:JavaFXGameCharacters/hero.png", 50, 64, true, false);
		Image enemy = new Image("file:JavaFXGameCharacters/enemya.png", 50, 64, true, false);
		Image dragon = new Image("file:JavaFXGameCharacters/enemyb.png", 270, 200, true, false);
		Image enemy2 = new Image("file:JavaFXGameCharacters/enemyc.png", 50, 64, true, false);
		Image demon = new Image("file:JavaFXGameCharacters/enemyd.png", 76, 100, true, false);
		Image samurai = new Image("file:JavaFXGameCharacters/enemysamurai.png", 76, 100, true, false);
		Image werewolf = new Image("file:JavaFXGameCharacters/enemywolf.png", 50, 64, true, false);

		Image swordslash = new Image("file:JavaFXGameCharacters/swordslash.png", 50, 64, true, false);

		// Button1Copy
		Button BC = new Button("Quit");
		BC.setLayoutX(0);
		BC.setLayoutY(0);
		BC.setOnAction(e -> {

		window.setScene(scene2);
		playerCharacter.setPosition(24, 24);

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


		Gamer = new AnimationTimer() {
			public void handle(long currentNanoTime) {
				double t = (currentNanoTime - startNanoTime) / 1000000000.0;

				gc.clearRect(0, 0, 1024, 768);
				gc.drawImage(Courtyard.getBackgroundImage(), 0, 0);

				// going up
				if (input.contains(Keys[0])) {
					if (KeyLast[0] && (playerCharacter.getTopLeftY() != 24)) {
						playerCharacter.moveToPosition(Courtyard.getAllBoxLocations(), 0, -Movement);
					} else {
						KeyLast[0] = true;
					}

				} else {
					KeyLast[0] = false;
				}
				// going left
				if (input.contains(Keys[1])) {
					if ((KeyLast[1] && (playerCharacter.getTopLeftX() != 24))) {
						playerCharacter.setTexture(hero);
						playerCharacter.moveToPosition(Courtyard.getAllBoxLocations(), -Movement, 0);

					} else {
						KeyLast[1] = true;

					}

				} else {
					KeyLast[1] = false;
				}
				// going down
				if (input.contains(Keys[2])) {
					if (KeyLast[2] && (playerCharacter.getTopLeftY() != 680)) {
						playerCharacter.moveToPosition(Courtyard.getAllBoxLocations(), 0, Movement);
					} else {
						KeyLast[2] = true;

					}

				} else {
					KeyLast[2] = false;
				}
				// going right
				if (input.contains(Keys[3])) {
					if (KeyLast[3] && (playerCharacter.getTopLeftX() != 949)) {
						playerCharacter.setTexture(heroflip);
						playerCharacter.moveToPosition(Courtyard.getAllBoxLocations(), Movement, 0);

					} else {
						KeyLast[3] = true;

					}

				} else {
					KeyLast[3] = false;
				}

				gc.drawImage(playerCharacter.getTexture(), playerCharacter.getTopLeftX(), playerCharacter.getTopLeftY());

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
		gc3.drawImage(Mountain.getBackgroundImage(), 0, 0);
		scene3 = new Scene(root3);

		// Layout2
		Group root2 = new Group();
		Canvas canvas2 = new Canvas(1024, 768);
		root2.getChildren().add(canvas2);
		root2.getChildren().add(B2);
		root2.getChildren().add(B3);
		GraphicsContext gc2 = canvas2.getGraphicsContext2D();
		gc2.drawImage(TitleScreen.getBackgroundImage(), 0, 0);
		scene2 = new Scene(root2);

		// end stuff

		window.setScene(scene2);
		window.setTitle("Welcome!");
		window.show();
	}

}