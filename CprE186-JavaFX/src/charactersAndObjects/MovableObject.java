package charactersAndObjects;

import java.util.ArrayList;

import javafx.scene.image.Image;

/**
 * This class extends GameObject to allow for the object to be moved dynamically
 * and not interfere with CollisionBoxes
 *
 * @author Isaac
 *
 */
public class MovableObject extends GameObject {
	/**
	 * Constructor for MovableObject which takes a CollisionBox and an Image
	 *
	 * @param givenBox
	 *            CollisionBox of this GameObject
	 * @param givenTexture
	 *            Image texture for this GameObject
	 */
	public MovableObject(CollisionBox givenBox, Image givenTexture) {
		super(givenBox, givenTexture);
	}

	/**
	 * Constructor for MovableObject that takes the arguments for a CollisionBox
	 * instead of taking a CollisionBox
	 *
	 * @param xPosition
	 *            X position for the CollisionBox
	 * @param yPosition
	 *            Y position for the CollisionBox
	 * @param givenWidth
	 *            Width of the CollisionBox
	 * @param givenHeight
	 *            Height of the CollisionBox
	 * @param givenTexture
	 *            Texture for this MovableObject
	 */
	public MovableObject(int xPosition, int yPosition, int givenWidth, int givenHeight, Image givenTexture) {
		super(xPosition, yPosition, givenWidth, givenHeight, givenTexture);
	}

	/**
	 * Constructor for a MovableObject that takes an X and Y position and an
	 * image, and uses the image's width and height to determine the
	 * CollisionBox
	 *
	 * @param xPosition
	 *            X position of the CollisionBox
	 * @param yPosition
	 *            Y position of the CollisionBox
	 * @param givenTexture
	 *            Texture of this MovableObject
	 */
	public MovableObject(int xPosition, int yPosition, Image givenTexture) {
		super(xPosition, yPosition, givenTexture);
	}

	/**
	 * Constructor for a MovableObject which takes an Image texture and sets the
	 * CollisionBox to null
	 *
	 * @param givenTexture
	 *            The texture of this GameObject
	 */
	public MovableObject(Image givenTexture) {
		super(givenTexture);
	}

	/**
	 * Moves this MovableObject to a position, making sure it doesn't collide
	 * with the CollisionBoxes in the given ArrayList of CollisionBoxes
	 *
	 * @param boxes
	 *            The CollisionBoxes this MovableObject cannot collide with
	 * @param xMove
	 *            The translation in the x direction
	 * @param yMove
	 *            The translation in the y direction
	 */
	public void moveToPosition(ArrayList<CollisionBox> boxes, int xMove, int yMove) {
		super.getCollisionBox().translateBoxWithCollision(boxes, xMove, yMove);
	}
}
