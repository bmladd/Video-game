package application;
	
import java.util.ArrayList;
import java.util.List;

import inanimateObjects.MovableObject;
import javafx.scene.image.Image;
/*
 * class for creating and implementing AI characters in the game workspace utilizing 
 * elements from the main and charactersAndObjects package.
 */

public class AIcharacter extends SwitchingScenes {
	
	// images for creating the AI
	private static Image enemy = new Image("file:JavaFXGameCharacters/enemya.png", 50, 64, true, false);
	private static Image dragon = new Image("file:JavaFXGameCharacters/enemyb.png", 270, 200, true, false);
	private static Image enemy2 = new Image("file:JavaFXGameCharacters/enemyc.png", 50, 64, true, false);
	private static Image demon = new Image("file:JavaFXGameCharacters/enemyd.png", 76, 100, true, false);
	private static Image samurai = new Image("file:JavaFXGameCharacters/enemysamurai.png", 76, 100, true, false);
	private static Image werewolf = new Image("file:JavaFXGameCharacters/enemywolf.png", 50, 64, true, false);
	
	//AI as movable objects in the environment
	MovableObject Enemy = new MovableObject(25,25, enemy);
	
	private static MovableObject Dragon = new MovableObject(200,200, dragon);
	
	private static MovableObject Enemy2 = new MovableObject(25,25, enemy2);
	
	private MovableObject Demon = new MovableObject(25,25,demon);
	
	private static MovableObject Werewolf = new MovableObject(25,25, werewolf);
	
	private static MovableObject Samurai = new MovableObject(25,25, samurai);
	
	
	
	/* positions and movements for each character
	 *note, not all characters need/will to be used
	 */
	public static void drawDragon(){
		Dragon.setPosition(500,250);
	}
	public static double getX(){
		return Dragon.getTopLeftX();
	}
	public static double getY(){
		return Dragon.getTopLeftY();
	}
	/*
	 * Collision boxes and health for AI
	 */
	
}
