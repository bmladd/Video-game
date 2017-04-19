package application;
	
import java.util.ArrayList;
import java.util.List;

import charactersAndObjects.MovableObject;
import javafx.scene.image.Image;
/*
 * class for creating and implementing AI characters in the game workspace utilizing 
 * elements from the main and charactersAndObjects package.
 */

public class AIcharacter extends SwitchingScenes {
	
	// images for creating the AI
	Image enemy = new Image("file:JavaFXGameCharacters/enemya.png", 50, 64, true, false);
	Image dragon = new Image("file:JavaFXGameCharacters/enemyb.png", 270, 200, true, false);
	Image enemy2 = new Image("file:JavaFXGameCharacters/enemyc.png", 50, 64, true, false);
	Image demon = new Image("file:JavaFXGameCharacters/enemyd.png", 76, 100, true, false);
	Image samurai = new Image("file:JavaFXGameCharacters/enemysamurai.png", 76, 100, true, false);
	Image werewolf = new Image("file:JavaFXGameCharacters/enemywolf.png", 50, 64, true, false);
	
	//AI as movable objects in the environment
	MovableObject Enemy = new MovableObject(25,25, enemy);
	
	MovableObject Dragon = new MovableObject(200,200, dragon);
	
	MovableObject Enemy2 = new MovableObject(25,25, enemy2);
	
	MovableObject Demon = new MovableObject(25,25,demon);
	
	MovableObject Werewolf = new MovableObject(25,25, werewolf);
	
	MovableObject Samurai = new MovableObject(25,25, samurai);
	
	/* positions and movements for each character
	 *note, not all characters need/will to be used
	 */
	
	/*
	 * Collision boxes and health for AI
	 */
	
}
