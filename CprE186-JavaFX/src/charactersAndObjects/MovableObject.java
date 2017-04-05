package charactersAndObjects;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class MovableObject extends GameObject{

	public MovableObject(CollisionBox givenBox, Image givenTexture) {
		super(givenBox, givenTexture);
	}

	public MovableObject(int xPosition, int yPosition, int givenWidth, int givenHeight, Image givenTexture){
		super(xPosition, yPosition, givenWidth, givenHeight, givenTexture);
	}

	public void moveToPosition(ArrayList<CollisionBox> boxes, int xMove, int yMove){
		super.getCollisionBox().translateBoxNoCollisions(boxes, xMove, yMove);
	}
}
