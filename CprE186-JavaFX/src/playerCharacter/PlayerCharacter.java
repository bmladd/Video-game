package playerCharacter;

import inanimateObjects.CollisionBox;
import inanimateObjects.MovableObject;
import javafx.scene.image.Image;

public class PlayerCharacter extends MovableObject {

	public PlayerCharacter(CollisionBox givenBox, Image givenTexture) {
		super(givenBox, givenTexture);
	}

	public PlayerCharacter(int xPosition, int yPosition, Image givenTexture) {
		super(xPosition, yPosition, givenTexture);
	}

	public PlayerCharacter(Image givenTexture) {
		super(givenTexture);
	}

	public PlayerCharacter(int xPosition, int yPosition, int givenWidth, int givenHeight, Image givenTexture) {
		super(xPosition, yPosition, givenWidth, givenHeight, givenTexture);
	}
}
