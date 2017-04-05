package charactersAndObjects;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class CollisionBox {
	private Rectangle cBox;
	private Point topLeft;
	private Point topRight;
	private Point bottomLeft;
	private Point bottomRight;

	public CollisionBox(int givenX, int givenY, int givenWidth, int givenHeight) {
		cBox = new Rectangle(givenX, givenY, givenWidth, givenHeight);
		topLeft = cBox.getLocation();
		topRight = new Point(topLeft.x + (int)cBox.getWidth(), topLeft.y);
		bottomLeft = new Point(topLeft.x, topLeft.y + (int)cBox.getHeight());
		bottomRight = new Point(topLeft.x + (int)cBox.getWidth(), topLeft.y + (int)cBox.getHeight());
	}

	public CollisionBox(CollisionBox givenBox) {
		cBox = givenBox.getRectangle();
		topLeft = givenBox.getTopLeft();
		topRight = givenBox.getTopRight();
		bottomLeft = givenBox.getBottomLeft();
		bottomRight = givenBox.getBottomRight();
	}

	public Rectangle getRectangle() {
		return cBox;
	}

	public Point getTopLeft() {
		return topLeft;
	}

	public Point getTopRight() {
		return topRight;
	}

	public Point getBottomLeft() {
		return bottomLeft;
	}

	public Point getBottomRight() {
		return bottomRight;
	}

	public void moveBoxTo(int xPos, int yPos){
		cBox.setLocation(xPos, yPos);
		topLeft = cBox.getLocation();
		topRight = new Point(topLeft.x + (int)cBox.getWidth(), topLeft.y);
		bottomLeft = new Point(topLeft.x, topLeft.y + (int)cBox.getHeight());
		bottomRight = new Point(topLeft.x + (int)cBox.getWidth(), topLeft.y + (int)cBox.getHeight());
	}

	public void translateBox(int xMove, int yMove){
		cBox.translate(xMove, yMove);
		topLeft = cBox.getLocation();
		topRight = new Point(topLeft.x + (int)cBox.getWidth(), topLeft.y);
		bottomLeft = new Point(topLeft.x, topLeft.y + (int)cBox.getHeight());
		bottomRight = new Point(topLeft.x + (int)cBox.getWidth(), topLeft.y + (int)cBox.getHeight());
	}

	public void translateBoxNoCollisions(ArrayList<CollisionBox> boxes, int xMove, int yMove){
		int distX = 0;
		int distY = 0;
		for(int i = 0; i <= xMove; i++){
			if(canMoveX(boxes, i)){
				distX = i;
			}
			else{
				break;
			}
		}
		translateBox(distX, 0);
		for(int i = 0; i <= yMove; i++){
			if(canMoveY(boxes, i)){
				distY = i;
			}
			else{
				break;
			}
		}
		translateBox(0, distY);
	}

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

	public boolean isColliding(ArrayList<CollisionBox> boxes){
		for(int i = 0; i < boxes.size(); i++){
			if(!this.equals(boxes.get(i))){
				if(isColliding(boxes.get(i))){
					return true;
				}
			}
		}
		return false;
	}

	public boolean canMoveX(ArrayList<CollisionBox> boxes ,int xTranslate) {
		return canMove(boxes, xTranslate, 0);
	}

	public boolean canMoveY(ArrayList<CollisionBox> boxes ,int yTranslate){
		return canMove(boxes, 0, yTranslate);
	}

	public boolean canMove(ArrayList<CollisionBox> boxes, int xTranslate, int yTranslate){
		CollisionBox nextPosition = new CollisionBox(this);
		nextPosition.translateBox(xTranslate, yTranslate);
		return !nextPosition.isColliding(boxes);
	}
}
