package charactersAndObjects;

import javafx.scene.image.Image;

/**
 * This is a class which encapsulates all of the necessary methods for unmoving
 * objects in our game.
 *
 * @author Isaac
 *
 */
public class GameObject {
	/**
	 * This GameObject's CollisionBox
	 */
	private CollisionBox collision;

	/**
	 * This GameObject's texture
	 */
	private Image texture;

	/**
	 * Constructor for GameObject that takes a CollisionBox and an Image
	 *
	 * @param givenBox
	 *            CollisionBox of this GameObject
	 * @param givenTexture
	 *            Image texture for this GameObject
	 */
	public GameObject(CollisionBox givenBox, Image givenTexture) {
		collision = givenBox;
		texture = givenTexture;
	}

	/**
	 * Constructor for GameObject that takes the arguments for a CollisionBox
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
	 *            Texture for this GameObject
	 */
	public GameObject(int xPosition, int yPosition, int givenWidth, int givenHeight, Image givenTexture) {
		collision = new CollisionBox(xPosition, yPosition, givenWidth, givenHeight);
		texture = givenTexture;
	}

	/**
	 * Constructor for a GameObject that takes an X and Y position and an image,
	 * and uses the image's width and height to determine the CollisionBox
	 *
	 * @param xPosition
	 *            X position of the CollisionBox
	 * @param yPosition
	 *            Y position of the CollisionBox
	 * @param givenTexture
	 *            Texture of this GameObject
	 */
	public GameObject(int xPosition, int yPosition, Image givenTexture) {
		collision = new CollisionBox(xPosition, yPosition, (int) givenTexture.getWidth(),
				(int) givenTexture.getHeight());
		texture = givenTexture;
	}

	/**
	 * Constructor for a GameObject which takes an Image texture and sets the
	 * CollisionBox to null
	 *
	 * @param givenTexture
	 *            The texture of this GameObject
	 */
	public GameObject(Image givenTexture) {
		collision = null;
		texture = givenTexture;
	}

	/**
	 * Sets the texture of this GameObject
	 *
	 * @param givenTexture
	 *            The texture to change this GameObject's texture to
	 */
	public void setTexture(Image givenTexture) {
		texture = givenTexture;
	}

	/**
	 * Returns the texture of this GameObject
	 *
	 * @return texture of this object
	 */
	public Image getTexture() {
		return texture;
	}

	/**
	 * Returns the collision box of this object.
	 *
	 * @return collision
	 */
	public CollisionBox getCollisionBox() {
		return collision;
	}

	/**
	 * Sets/changes the collision box of this object
	 *
	 * @param givenBox
	 *            The collision box to give this GameObject
	 */
	public void setCollisionBox(CollisionBox givenBox) {
		collision = givenBox;
	}

	/**
	 * Sets/changes the collision box of this object
	 *
	 * @param xPosition
	 *            The x coordinate of this GameObject's CollisionBox
	 * @param yPosition
	 *            The y coordinate of this GameObject's CollisionBox
	 */
	public void setCollisionBox(int xPosition, int yPosition) {
		collision = new CollisionBox(xPosition, yPosition, (int) texture.getWidth(), (int) texture.getHeight());
	}

	/**
	 * Sets/changes the collision box of this object. (Use this method when the
	 * width and height of the image do not correspond to its CollisionBox)
	 *
	 * @param xPosition
	 *            The x coordinate of this GameObject's CollisionBox
	 * @param yPosition
	 *            The y coordinate of this GameObject's CollisionBox
	 * @param width
	 *            The width of this GameObject's CollisionBox
	 * @param height
	 *            The height of this GameObject's CollisionBox
	 */
	public void setCollisionBox(int xPosition, int yPosition, int width, int height) {
		collision = new CollisionBox(xPosition, yPosition, width, height);
	}

	/**
	 * Sets the position of this GameObject to an x and y coordinate.
	 *
	 * @param xPos
	 *            The given x position for this GameObject.
	 * @param yPos
	 *            The given y position for this GameObject.
	 */
	public void setPosition(int xPos, int yPos) {
		if (collision.equals(null)) {
			collision = new CollisionBox(xPos, yPos, (int) texture.getWidth(), (int) texture.getHeight());
		} else {
			collision.moveBoxTo(xPos, yPos);
		}

	}
}
