package inanimateObjects;

import javafx.scene.image.Image;

/**
 * This is a class which encapsulates all of the necessary methods for unmoving
 * objects in our game.
 *
 * @author Isaac
 *
 */
public class ImmovableObject extends GameObject{

	public ImmovableObject(CollisionBox givenBox, Image givenTexture) {
		super(givenBox, givenTexture);
	}

	public ImmovableObject(int xPosition, int yPosition, int givenWidth, int givenHeight, Image givenTexture) {
		super(xPosition, yPosition, givenWidth, givenHeight, givenTexture);
	}

	public ImmovableObject(int xPosition, int yPosition, Image givenTexture) {
		super(xPosition, yPosition, givenTexture);
	}

	public ImmovableObject(Image givenTexture){
		super(givenTexture);
	}
}
