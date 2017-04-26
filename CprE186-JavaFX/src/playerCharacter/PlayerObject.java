package playerCharacter;

import inanimateObjects.CollisionBox;
import inanimateObjects.MovableObject;
import javafx.scene.image.Image;

public class PlayerObject extends MovableObject {

	public PlayerObject(CollisionBox givenBox, Image givenTexture) {
		super(givenBox, givenTexture);
	}

	public PlayerObject(int xPosition, int yPosition, Image givenTexture) {
		super(xPosition, yPosition, givenTexture);
	}

	public PlayerObject(Image givenTexture) {
		super(givenTexture);
	}

	public PlayerObject(int xPosition, int yPosition, int givenWidth, int givenHeight, Image givenTexture) {
		super(xPosition, yPosition, givenWidth, givenHeight, givenTexture);
	}
}
