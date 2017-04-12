package charactersAndObjects;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * This class is a way to keep track of and check for collisions between
 * different objects.
 *
 * @author Isaac
 *
 */
public class CollisionBox {
	/**
	 * The Rectangle determining the size and position of this CollisionBox
	 */
	private Rectangle cBox;

	/**
	 * The top left Point of this CollisionBox
	 */
	private Point topLeft;

	/**
	 * The top right Point of this CollisionBox
	 */
	private Point topRight;

	/**
	 * The bottom left Point of this CollisionBox
	 */
	private Point bottomLeft;

	/**
	 * The bottom right Point of this CollisionBox
	 */
	private Point bottomRight;

	/**
	 * Constructor for a CollisionBox which takes the x and y coordinates of the
	 * top left point of this CollisionBox, a width, and a height
	 *
	 * @param givenX
	 *            The x coordinate of the top left point of this CollisionBox
	 * @param givenY
	 *            The y coordinate of the top left point of this CollisionBox
	 * @param givenWidth
	 *            The width of this CollisionBox
	 * @param givenHeight
	 *            The height of this CollisionBox
	 */
	public CollisionBox(int givenX, int givenY, int givenWidth, int givenHeight) {
		cBox = new Rectangle(givenX, givenY, givenWidth, givenHeight);
		topLeft = cBox.getLocation();
		topRight = new Point(topLeft.x + (int) cBox.getWidth(), topLeft.y);
		bottomLeft = new Point(topLeft.x, topLeft.y + (int) cBox.getHeight());
		bottomRight = new Point(topLeft.x + (int) cBox.getWidth(), topLeft.y + (int) cBox.getHeight());
	}

	/**
	 * Constructor for a CollisionBox which takes another CollisionBox and sets
	 * this CollisionBox equal to it.
	 *
	 * @param givenBox
	 *            The CollisionBox to set this CollisionBox to
	 */
	public CollisionBox(CollisionBox givenBox) {
		cBox = new Rectangle(givenBox.getRectangle());
		topLeft = new Point(givenBox.getTopLeft());
		topRight = new Point(givenBox.getTopRight());
		bottomLeft = new Point(givenBox.getBottomLeft());
		bottomRight = new Point(givenBox.getBottomRight());
	}

	/**
	 * Getter for this CollisionBox's Rectangle
	 *
	 * @return Rectangle cBox
	 */
	public Rectangle getRectangle() {
		return cBox;
	}

	/**
	 * Getter for the top left Point of this CollisionBox
	 *
	 * @return top left Point of this CollisionBox
	 */
	public Point getTopLeft() {
		return topLeft;
	}

	/**
	 * Getter for the top right Point of this CollisionBox
	 *
	 * @return top right Point of this CollisionBox
	 */
	public Point getTopRight() {
		return topRight;
	}

	/**
	 * Getter for the bottom left Point of this CollisionBox
	 *
	 * @return bottom left Point of this CollisionBox
	 */
	public Point getBottomLeft() {
		return bottomLeft;
	}

	/**
	 * Getter for the bottom right Point of this CollisionBox
	 *
	 * @return bottom right Point of this CollisionBox
	 */
	public Point getBottomRight() {
		return bottomRight;
	}

	/**
	 * Sets this CollisionBox's location to a specified x and y position for the
	 * top left point of the box
	 *
	 * @param xPos
	 *            x position for the top left of this CollisionBox
	 * @param yPos
	 *            y position for the top left of this CollisionBox
	 */
	public void moveBoxTo(int xPos, int yPos) {
		cBox.setLocation(xPos, yPos);
		topLeft = cBox.getLocation();
		topRight = new Point(topLeft.x + (int) cBox.getWidth(), topLeft.y);
		bottomLeft = new Point(topLeft.x, topLeft.y + (int) cBox.getHeight());
		bottomRight = new Point(topLeft.x + (int) cBox.getWidth(), topLeft.y + (int) cBox.getHeight());
	}

	/**
	 * Sets this CollisionBox's location based on a given top left Point.
	 *
	 * @param newTopLeft
	 *            New location for the top left Point of this CollisionBox.
	 */
	public void moveBoxTo(Point newTopLeft) {
		cBox.setLocation(newTopLeft);
		topLeft = cBox.getLocation();
		topRight = new Point(topLeft.x + (int) cBox.getWidth(), topLeft.y);
		bottomLeft = new Point(topLeft.x, topLeft.y + (int) cBox.getHeight());
		bottomRight = new Point(topLeft.x + (int) cBox.getWidth(), topLeft.y + (int) cBox.getHeight());
	}

	/**
	 * Translates this CollisionBox by a given x and y amount, ignoring
	 * collisions
	 *
	 * @param xMove
	 *            Distance to translate this CollisionBox in the x direction.
	 * @param yMove
	 *            Distance to translate this CollisionBox in the y direction.
	 */
	public void translateBoxIgnoreCollision(int xMove, int yMove) {
		cBox.translate(xMove, yMove);
		topLeft = cBox.getLocation();
		topRight = new Point(topLeft.x + (int) cBox.getWidth(), topLeft.y);
		bottomLeft = new Point(topLeft.x, topLeft.y + (int) cBox.getHeight());
		bottomRight = new Point(topLeft.x + (int) cBox.getWidth(), topLeft.y + (int) cBox.getHeight());
	}

	/**
	 * Translates this CollisionBox by a given x and y amount, and disallows
	 * collisions between this box and the boxes in the given ArrayList. Also
	 * accounts for this CollisionBox being in the given ArrayList of
	 * CollisionBoxes by ignoring any CollisionBoxes that are exactly equal to
	 * this one.
	 *
	 * @param boxes
	 *            An ArrayList of CollisionBoxes to check for collisions with.
	 * @param xMove
	 *            The distance to translate this CollisionBox in the x
	 *            direction.
	 * @param yMove
	 *            The distance to translate this CollisionBox in the y
	 *            direction.
	 */
	public void translateBoxWithCollision(ArrayList<CollisionBox> boxes, int xMove, int yMove) {
		if (canMoveX(boxes, xMove)) {
			translateBoxIgnoreCollision(xMove, 0);;
		}
		else{
			if(xMove > 0){
				translateBoxWithCollision(boxes, xMove - 1, 0);
			}
			else if(xMove < 0){
				translateBoxWithCollision(boxes, xMove + 1, 0);
			}
		}

		if (canMoveY(boxes, yMove)) {
			translateBoxIgnoreCollision(0, yMove);;
		}
		else{
			if(yMove > 0){
				translateBoxWithCollision(boxes, 0, yMove - 1);
			}
			else if(yMove < 0){
				translateBoxWithCollision(boxes, 0, yMove + 1);
			}
		}
	}

	/**
	 * Checks to see if this CollisionBox is colliding with another
	 * CollisionBox.
	 *
	 * @param otherBox
	 *            The CollisionBox to check against.
	 * @return true if this CollisionBox is colliding with the given
	 *         CollisionBox, false otherwise.
	 */
	public boolean isColliding(CollisionBox otherBox) {
		if (cBox.intersects(otherBox.getRectangle())) {
			return true;
		}
		if (cBox.contains(otherBox.getRectangle())) {
			return true;
		}
		if (otherBox.getRectangle().contains(cBox)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks to see if this CollisionBox is colliding with any other
	 * CollisionBox in the given ArrayList of CollisionBoxes
	 *
	 * @param boxes
	 *            An ArrayList of CollisionBoxes to check against
	 * @return true if this CollisionBox is colliding with another, false
	 *         otherwise
	 */
	public boolean isColliding(ArrayList<CollisionBox> boxes) {
		for (int i = 0; i < boxes.size(); i++) {
			if (!this.equals(boxes.get(i))) {
				if (isColliding(boxes.get(i))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks to see if this CollisionBox can move the given distance in the x
	 * direction without colliding with any CollisionBox in the given ArrayList
	 * of CollisionBoxes
	 *
	 * @param boxes
	 *            ArrayList of CollisionBoxes to check
	 * @param xTranslate
	 *            The distance to translate this CollisionBox in the x
	 *            direction.
	 * @return true if this CollisionBox can move without collision, false if it
	 *         collides
	 */
	public boolean canMoveX(ArrayList<CollisionBox> boxes, int xTranslate) {
		return canMove(boxes, xTranslate, 0);
	}

	/**
	 * Checks to see if this CollisionBox can move the given distance in the y
	 * direction without colliding with any CollisionBox in the given ArrayList
	 * of CollisionBoxes
	 *
	 * @param boxes
	 *            ArrayList of CollisionBoxes to check
	 * @param yTranslate
	 *            The distance to translate this CollisionBox in the y
	 *            direction.
	 * @return true if this CollisionBox can move without collision, false if it
	 *         collides
	 */
	public boolean canMoveY(ArrayList<CollisionBox> boxes, int yTranslate) {
		return canMove(boxes, 0, yTranslate);
	}

	/**
	 * Checks to see if this CollisionBox can move the given distance in the x
	 * and y direction without colliding with any CollisionBox in the given
	 * ArrayList of CollisionBoxes
	 *
	 * @param boxes
	 *            ArrayList of CollisionBoxes to check
	 * @param xTranslate
	 *            The distance to translate this CollisionBox in the x
	 *            direction.
	 * @param yTranslate
	 *            The distance to translate this CollisionBox in the y
	 *            direction.
	 * @return true if the CollisionBox does not collide during the translation,
	 *         false otherwise
	 */
	public boolean canMove(ArrayList<CollisionBox> boxes, int xTranslate, int yTranslate) {
		CollisionBox nextPosition = new CollisionBox(this);
		for (int i = 0; i < Math.abs(xTranslate); i++) {

			if (xTranslate > 0) {
				nextPosition.translateBoxIgnoreCollision(1, 0);
			} else {
				nextPosition.translateBoxIgnoreCollision(-1, 0);
			}
			if (nextPosition.isColliding(boxes)) {
				return false;
			}
		}
		for (int j = 0; j < Math.abs(yTranslate); j++) {
			if (yTranslate > 0) {
				nextPosition.translateBoxIgnoreCollision(0, 1);
			} else {
				nextPosition.translateBoxIgnoreCollision(0, -1);
			}
			if (nextPosition.isColliding(boxes)) {
				return false;
			}
		}

		return true;
	}
}
