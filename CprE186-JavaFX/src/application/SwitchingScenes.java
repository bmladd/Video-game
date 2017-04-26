package application;

import java.util.ArrayList;

import inanimateObjects.BackgroundObject;
import inanimateObjects.GameObject;
import items.Weapon;
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
import otherCharacters.AIcharacter;
import otherCharacters.NonPlayerCharacter;
import playerCharacter.PlayerCharacter;

public class SwitchingScenes extends Application {

	AnimationTimer Gamer;
	private static int Movement = 10;
	public Stage window;
	public Scene playableLevels, mainMenu, optionsMenu;
	private BackgroundObject currentBackground;

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
		Courtyard.addDoorsExtended(Constants.getCourtyardDoorsExtended());

		BackgroundObject Mountain = new BackgroundObject(Constants.Mountain);

		BackgroundObject ForestLake = new BackgroundObject(Constants.ForestLake);
		ForestLake.addCollisionBoxes(Constants.getForestLakeCollisions());
		ForestLake.addDoors(Constants.getForestLakeDoors());
		ForestLake.addDoorsExtended(Constants.getForestLakeDoorsExtended());

		BackgroundObject Temple = new BackgroundObject(Constants.Temple);
		Temple.addDoorsExtended(Constants.getTempleDoorsExtended());
		Temple.addDoors(Constants.getTempleDoors());
		Temple.addCollisionBoxes(Constants.getTempleCollisions());

		BackgroundObject Options = new BackgroundObject(Constants.Options);

		BackgroundObject TitleScreen = new BackgroundObject(Constants.TitleScreen);

		// Maps
		PlayerCharacter playerCharacter = new PlayerCharacter(24, 24, Constants.HeroRight);

		NonPlayerCharacter enemyOne = new NonPlayerCharacter(160, 24, Constants.Enemy1);
		Courtyard.addNPC(enemyOne);

		NonPlayerCharacter dragon = new NonPlayerCharacter((int) AIcharacter.getX(), (int) AIcharacter.getY(),
				Constants.Dragon);
		Mountain.addNPC(dragon);

		// The quit button
		Button QuitButton = new Button("Quit");
		QuitButton.setLayoutX(0);
		QuitButton.setLayoutY(0);
		QuitButton.setOnAction(e -> {

			window.setScene(mainMenu);
			playerCharacter.setPosition(24, 24);

		});
		// Layout for animation:
		Group root = new Group();
		playableLevels = new Scene(root);
		primarystage.setScene(playableLevels);
		Canvas canvas = new Canvas(1024, 768);
		root.getChildren().add(canvas);
		root.getChildren().add(QuitButton);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		// Animation Timer:
		final long startNanoTime = System.nanoTime();

		ArrayList<String> input = new ArrayList<String>();

		playableLevels.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				String code = e.getCode().toString();

				// only add once... prevent duplicates
				if (!input.contains(code))
					input.add(code);
			}
		});

		playableLevels.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				String code = e.getCode().toString();
				input.remove(code);
			}
		});

		boolean[] KeyLast = { false, false, false, false, false };
		String[] Keys = { "W", "A", "S", "D", "E" };

		currentBackground = Courtyard;

		Gamer = new AnimationTimer() {
			public void handle(long currentNanoTime) {
				double t = (currentNanoTime - startNanoTime) / 1000000000.0;
				boolean slash = false;
				gc.clearRect(0, 0, 1024, 768);
				gc.drawImage(currentBackground.getBackgroundImage(), 0, 0);

				// going up
				if (input.contains(Keys[0])) {
					if (KeyLast[0]) {
						if (playerCharacter.getCollisionBox().canMoveY(Constants.getLevelWalls(), -Movement)) {
							playerCharacter.moveToPosition(currentBackground.getAllBoxLocations(), 0, -Movement);
						} else if (!playerCharacter.getCollisionBox().canMoveY(currentBackground.getDoorsExtended(),
								-Movement)) {
							if (playerCharacter.getCollisionBox().canMoveY(currentBackground.getDoors(), -Movement)) {
								playerCharacter.moveToPosition(currentBackground.getAllBoxLocations(), 0, -Movement);
							}
						}
					} else {
						KeyLast[0] = true;
					}

				} else {
					KeyLast[0] = false;
				}
				// going left
				if (input.contains(Keys[1])) {
					if (KeyLast[1]) {
						if (playerCharacter.getCollisionBox().canMoveX(Constants.getLevelWalls(), -Movement)) {
							playerCharacter.setTexture(Constants.HeroRight);
							playerCharacter.moveToPosition(currentBackground.getAllBoxLocations(), -Movement, 0);
						} else if (!playerCharacter.getCollisionBox().canMoveX(currentBackground.getDoorsExtended(),
								-Movement)) {
							if (playerCharacter.getCollisionBox().canMoveX(currentBackground.getDoors(), -Movement)) {
								playerCharacter.setTexture(Constants.HeroRight);
								playerCharacter.moveToPosition(currentBackground.getAllBoxLocations(), -Movement, 0);
							}
						}

					} else {
						KeyLast[1] = true;

					}

				} else {
					KeyLast[1] = false;
				}
				// going down
				if (input.contains(Keys[2])) {
					if (KeyLast[2]) {
						if (playerCharacter.getCollisionBox().canMoveY(Constants.getLevelWalls(), Movement)) {
							playerCharacter.moveToPosition(currentBackground.getAllBoxLocations(), 0, Movement);
						} else if (!playerCharacter.getCollisionBox().canMoveY(currentBackground.getDoorsExtended(),
								Movement)) {
							if (playerCharacter.getCollisionBox().canMoveY(currentBackground.getDoors(), Movement)) {
								playerCharacter.moveToPosition(currentBackground.getAllBoxLocations(), 0, Movement);
							}
						}
					} else {
						KeyLast[2] = true;

					}

				} else {
					KeyLast[2] = false;
				}
				// going right
				if (input.contains(Keys[3])) {
					if (KeyLast[3]) {
						if (playerCharacter.getCollisionBox().canMoveX(Constants.getLevelWalls(), Movement)) {
							playerCharacter.setTexture(Constants.HeroLeft);
							playerCharacter.moveToPosition(currentBackground.getAllBoxLocations(), Movement, 0);
						} else if (!playerCharacter.getCollisionBox().canMoveX(currentBackground.getDoorsExtended(),
								Movement)) {
							if (playerCharacter.getCollisionBox().canMoveX(currentBackground.getDoors(), Movement)) {
								playerCharacter.setTexture(Constants.HeroLeft);
								playerCharacter.moveToPosition(currentBackground.getAllBoxLocations(), Movement, 0);
							} else if (!playerCharacter.getCollisionBox().canMoveX(currentBackground.getDoors().get(1),
									Movement)) {
								if (currentBackground.getBackgroundImage().equals((Courtyard.getBackgroundImage()))) {
									currentBackground = Temple;
									playerCharacter.setPosition(25, 25);
								} else if (currentBackground.getBackgroundImage()
										.equals((Temple.getBackgroundImage()))) {
									currentBackground = ForestLake;
									playerCharacter.setPosition(25, 25);
								} else if (currentBackground.getBackgroundImage()
										.equals((ForestLake.getBackgroundImage()))) {
									currentBackground = Mountain;
									playerCharacter.setPosition(25, 25);
								}

							}
						}

					} else {
						KeyLast[3] = true;

					}

				} else {
					KeyLast[3] = false;
				}
				// slashing
				if (input.contains(Keys[4])) {
					if (KeyLast[4]) {
						slash = false;
					} else {
						KeyLast[4] = true;
						slash = true;
					}

				} else {
					KeyLast[4] = false;
					slash = false;
				}

				gc.drawImage(playerCharacter.getTexture(), playerCharacter.getTopLeftX(),
						playerCharacter.getTopLeftY());
				if (slash) {
					if (playerCharacter.getTexture().equals(Constants.HeroLeft)) {
						playerCharacter.getWeapon().setCollisionBox(playerCharacter.getTopLeftX() + 30,
								playerCharacter.getTopLeftY() - 15);
						gc.drawImage(playerCharacter.getWeapon().getTexture(),
								playerCharacter.getWeapon().getCollisionBox().getTopLeft().getX(),
								playerCharacter.getWeapon().getCollisionBox().getTopLeft().getY());
					}
					if (playerCharacter.getTexture().equals(Constants.HeroRight)) {
						playerCharacter.getWeapon().setCollisionBox(playerCharacter.getTopLeftX() + 10,
								playerCharacter.getTopLeftY() - 15);
						gc.drawImage(playerCharacter.getWeapon().getTexture(),
								playerCharacter.getWeapon().getCollisionBox().getTopLeft().getX(),
								playerCharacter.getWeapon().getCollisionBox().getTopLeft().getY(), (double) -30,
								(double) 64);
					}
					currentBackground.hitNPCs(playerCharacter.getWeapon());
				}
				for (int i = 0; i < currentBackground.getNPCs().size(); i++) {
					if (!currentBackground.getNPCs().get(i).isDead()) {
						gc.drawImage(currentBackground.getNPCs().get(i).getTexture(),
								currentBackground.getNPCs().get(i).getCollisionBox().getTopLeft().getX(),
								currentBackground.getNPCs().get(i).getCollisionBox().getTopLeft().getY());
						if (currentBackground.getNPCs().get(i).isAttacking()) {
							if (currentBackground.getNPCs().get(i).facingLeft()) {
								currentBackground.getNPCs().get(i).getWeapon().setCollisionBox(
										currentBackground.getNPCs().get(i).getTopLeftX() + 30,
										currentBackground.getNPCs().get(i).getTopLeftY() - 15);
								gc.drawImage(currentBackground.getNPCs().get(i).getWeapon().getTexture(),
										currentBackground.getNPCs().get(i).getWeapon().getCollisionBox().getTopLeft()
												.getX(),
										currentBackground.getNPCs().get(i).getWeapon().getCollisionBox().getTopLeft()
												.getY());
							} else {
								currentBackground.getNPCs().get(i).getWeapon().setCollisionBox(
										currentBackground.getNPCs().get(i).getTopLeftX() + 10,
										currentBackground.getNPCs().get(i).getTopLeftY() - 15);
								gc.drawImage(currentBackground.getNPCs().get(i).getWeapon().getTexture(),
										currentBackground.getNPCs().get(i).getWeapon().getCollisionBox().getTopLeft()
												.getX(),
										currentBackground.getNPCs().get(i).getWeapon().getCollisionBox().getTopLeft()
												.getY(),
										(double) -30, (double) 64);
							}
						}
					}
				}
				currentBackground.handleNPCs(playerCharacter);
				// clear the canvas
				// Background image clears canvas

			}
		};
		//

		// Button1
		Button B = new Button("Quit");
		B.setLayoutX(0);
		B.setLayoutY(0);
		B.setOnAction(e -> window.setScene(mainMenu));

		// Button3
		Button B3 = new Button("Options");
		B3.setLayoutX(430);
		B3.setLayoutY(580);
		B3.setPrefSize(160, 60);
		B3.setOnAction(e -> window.setScene(optionsMenu));
		// Button2
		Button B2 = new Button("Play");
		B2.setLayoutX(430);
		B2.setLayoutY(500);
		B2.setPrefSize(160, 60);
		B2.setOnAction(e -> {

			window.setScene(playableLevels);
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
		gc3.drawImage(Options.getBackgroundImage(), 0, 0);
		optionsMenu = new Scene(root3);

		// Layout2
		Group root2 = new Group();
		Canvas canvas2 = new Canvas(1024, 768);
		root2.getChildren().add(canvas2);
		root2.getChildren().add(B2);
		root2.getChildren().add(B3);
		GraphicsContext gc2 = canvas2.getGraphicsContext2D();
		gc2.drawImage(TitleScreen.getBackgroundImage(), 0, 0);
		mainMenu = new Scene(root2);

		// end stuff

		window.setScene(mainMenu);
		window.setTitle("Welcome!");
		window.show();
	}

}