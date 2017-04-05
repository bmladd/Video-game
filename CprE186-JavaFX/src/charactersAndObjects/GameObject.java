package charactersAndObjects;

import javafx.scene.image.Image;

public class GameObject {
	private CollisionBox collision;
	private Image texture;

	public GameObject(CollisionBox givenBox, Image givenTexture){
		collision = givenBox;
		texture = givenTexture;
	}

	public GameObject(int xPosition, int yPosition, int givenWidth, int givenHeight, Image givenTexture){
		collision = new CollisionBox(xPosition, yPosition, givenWidth, givenHeight);
		texture = givenTexture;
	}

	public GameObject(int xPosition, int yPosition, Image givenTexture){
		collision = new CollisionBox(xPosition, yPosition, (int) givenTexture.getWidth(), (int) givenTexture.getHeight());
		texture = givenTexture;
	}

	public void setTexture(Image givenTexture){
		texture = givenTexture;
	}

	public Image getTexture(){
		return texture;
	}

	public CollisionBox getCollisionBox(){
		return collision;
	}

	public void setPosition(int xPos, int yPos){
		collision.moveBoxTo(xPos, yPos);
	}
}
