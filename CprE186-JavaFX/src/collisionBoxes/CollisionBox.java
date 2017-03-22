package collisionBoxes;

public class CollisionBox {
	private int[] xPositions = new int[2];
	private int[] yPositions = new int[2];
	private int height;
	private int width;

	public CollisionBox(int givenX, int givenY, int givenHeight, int givenWidth){
		xPositions[0] = givenX;
		xPositions[1] = givenX + givenWidth;
		yPositions[0] = givenY - givenHeight;
		yPositions[1] = givenY;
		height = givenHeight;
		width = givenWidth;
	}

	public int getMinX(){
		return xPositions[0];
	}

	public int getMaxX(){
		return xPositions[1];
	}

	public int getMinY(){
		return yPositions[0];
	}

	public int getMaxY(){
		return yPositions[1];
	}

	public int getHeight(){
		return height;
	}

	public int getWidth(){
		return width;
	}

	public boolean[] isColliding(CollisionBox other, int xMove, int yMove){
		boolean[] xyCollision = {false, false};
		if(xMove < 0){
			if((other.getMinX() + xMove) < getMaxX()){
				xyCollision[0] = true;
			}
		}
		else if(xMove > 0){
			if((other.getMaxX() + xMove) > getMinX()){
				xyCollision[0] = true;
			}
		}

		if(yMove < 0){
			if((other.getMinY() + yMove) < getMaxY()){
				xyCollision[1] = true;
			}
		}
		else if(yMove > 0){
			if((other.getMaxY() + yMove) > getMinY()){
				xyCollision[1] = true;
			}
		}

		return xyCollision;
	}
}
