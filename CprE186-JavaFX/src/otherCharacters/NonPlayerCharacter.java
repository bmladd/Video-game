package otherCharacters;

import inanimateObjects.CollisionBox;
import inanimateObjects.MovableObject;
import javafx.scene.image.Image;

public class NonPlayerCharacter extends MovableObject {
	public NonPlayerCharacter(CollisionBox givenBox, Image givenTexture) {
		super(givenBox, givenTexture);
	}

	public NonPlayerCharacter(int xPosition, int yPosition, Image givenTexture) {
		super(xPosition, yPosition, givenTexture);
	}

	public NonPlayerCharacter(Image givenTexture) {
		super(givenTexture);
	}

	public NonPlayerCharacter(int xPosition, int yPosition, int givenWidth, int givenHeight, Image givenTexture) {
		super(xPosition, yPosition, givenWidth, givenHeight, givenTexture);
	}
}
