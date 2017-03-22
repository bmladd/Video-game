package collisionBoxes;

import java.util.ArrayList;

public class CollisionBox {
	private int[] xPositions = new int[2];
	private int[] yPositions = new int[2];
	private int[] topLeft = new int[2];
	private int[] topRight = new int[2];
	private int[] bottomLeft = new int[2];
	private int[] bottomRight = new int[2];
	private int height;
	private int width;

	public CollisionBox(int givenX, int givenY, int givenHeight, int givenWidth) {
		xPositions[0] = givenX;
		xPositions[1] = givenX + givenWidth;
		yPositions[0] = givenY - givenHeight;
		yPositions[1] = givenY;
		height = givenHeight;
		width = givenWidth;
		topLeft[0] = xPositions[0];
		topRight[0] = xPositions[1];
		bottomLeft[0] = xPositions[0];
		bottomRight[0] = xPositions[1];

		topLeft[1] = yPositions[0];
		topRight[1] = yPositions[1];
		bottomLeft[1] = yPositions[0];
		bottomRight[1] = yPositions[1];
	}

	public CollisionBox(CollisionBox other, int xTranslate, int yTranslate) {
		xPositions[0] = other.getMinX() + xTranslate;
		xPositions[1] = xPositions[0] + other.getWidth();
		yPositions[0] = other.getMinY() + yTranslate;
		yPositions[1] = yPositions[0] + other.getHeight();
		height = other.getHeight();
		width = other.getWidth();
		topLeft[0] = xPositions[0];
		topRight[0] = xPositions[1];
		bottomLeft[0] = xPositions[0];
		bottomRight[0] = xPositions[1];

		topLeft[1] = yPositions[0];
		topRight[1] = yPositions[1];
		bottomLeft[1] = yPositions[0];
		bottomRight[1] = yPositions[1];
	}

	public int getMinX() {
		return xPositions[0];
	}

	public int getMaxX() {
		return xPositions[1];
	}

	public int getMinY() {
		return yPositions[0];
	}

	public int getMaxY() {
		return yPositions[1];
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int[] getTopLeft() {
		return topLeft;
	}

	public int[] getTopRight() {
		return topRight;
	}

	public int[] getBottomLeft() {
		return bottomLeft;
	}

	public int[] getBottomRight() {
		return bottomRight;
	}

	/**
	 * Checks to see if another CollisionBox overlaps this one.
	 *
	 * @param other
	 *            Another CollisionBox to compare against this one.
	 * @return Whether the CollisionBox is colliding.
	 */
	public boolean isColliding(CollisionBox other) {
		int[] otherTopLeft = other.getTopLeft();
		int[] otherTopRight = other.getTopRight();
		int[] otherBottomLeft = other.getBottomLeft();
		int[] otherBottomRight = other.getBottomRight();
		if (isPointInside(otherTopLeft))
			return true;
		if (isPointInside(otherTopRight))
			return true;
		if (isPointInside(otherBottomLeft))
			return true;
		if (isPointInside(otherBottomRight))
			return true;
		return false;
	}

	public boolean isColliding(ArrayList<CollisionBox> others) {
		for (int i = 0; i < others.size(); i++) {
			CollisionBox other = others.get(i);
			int[] otherTopLeft = other.getTopLeft();
			int[] otherTopRight = other.getTopRight();
			int[] otherBottomLeft = other.getBottomLeft();
			int[] otherBottomRight = other.getBottomRight();
			if (isPointInside(otherTopLeft))
				return true;
			if (isPointInside(otherTopRight))
				return true;
			if (isPointInside(otherBottomLeft))
				return true;
			if (isPointInside(otherBottomRight))
				return true;
		}
		return false;
	}

	/**
	 * Checks to see if this CollisionBox will collide with a specific other
	 * CollisionBox after it moves
	 *
	 * @param other
	 * @param xMove
	 * @param yMove
	 * @return Whether this collision box will collide with the other.
	 */
	public boolean willCollide(CollisionBox other, int xMove, int yMove) {
		CollisionBox nextPos = new CollisionBox(this, xMove, yMove);
		return isColliding(nextPos);
	}

	/**
	 * Checks to see if this CollisionBox will collide with any other
	 * CollisionBox after it moves
	 *
	 * @param others
	 * @param xMove
	 * @param yMove
	 * @return Whether or not this CollisionBox will collide after a move
	 */
	public boolean willThisCollide(ArrayList<CollisionBox> others, int xMove, int yMove) {
		CollisionBox nextPos = new CollisionBox(this, xMove, yMove);
		return nextPos.isColliding(others);
	}

	/**
	 * Checks to see if, when this CollisionBox moves, it will collide with this
	 * CollisionBox and finds what object it will collide with.
	 *
	 * @param others
	 * @param xMove
	 * @param yMove
	 * @return Returns the index of the object colliding with this one after it
	 *         moves
	 */
	public int indexOfCollidingObject(ArrayList<CollisionBox> others, int xMove, int yMove) {
		CollisionBox nextPos = new CollisionBox(this, xMove, yMove);
		if (willThisCollide(others, xMove, yMove)) {
			return nextPos.indexOfCollidingObject(others);
		}
		return -1;
	}

	/**
	 * Checks to see if this object is colliding with any other object, and
	 * returns the index of the object it is colliding with
	 *
	 * @param others
	 * @return The index of the CollisionBox that is colliding with this
	 *         CollisionBox
	 */
	public int indexOfCollidingObject(ArrayList<CollisionBox> others) {
		if (isColliding(others)) {
			for (int i = 0; i < others.size(); i++) {
				if (isColliding(others.get(i))) {
					return i;
				}
			}
		}
		return -1;
	}

	private boolean isPointInside(int x, int y) {
		if ((x < getMaxX()) && (x > getMinX()) && (y > getMinY()) && (y < getMinX())) {
			return true;
		}
		return false;
	}

	private boolean isPointInside(int[] point) {
		int x = point[0];
		int y = point[1];
		if ((x < getMaxX()) && (x > getMinX()) && (y > getMinY()) && (y < getMinX())) {
			return true;
		}
		return false;
	}
}
