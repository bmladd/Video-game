package otherCharacters;

import inanimateObjects.CollisionBox;
import inanimateObjects.MovableObject;
import javafx.scene.image.Image;

public class NonPlayerCharacter extends MovableObject {
	protected int health;
	protected boolean isDead;

	public NonPlayerCharacter(CollisionBox givenBox, Image givenTexture) {
		super(givenBox, givenTexture);
		isDead = false;
		health = 100;
	}

	public NonPlayerCharacter(int xPosition, int yPosition, Image givenTexture) {
		super(xPosition, yPosition, givenTexture);
		isDead = false;
		health = 100;
	}

	public NonPlayerCharacter(Image givenTexture) {
		super(givenTexture);
		isDead = false;
		health = 100;
	}

	public NonPlayerCharacter(int xPosition, int yPosition, int givenWidth, int givenHeight, Image givenTexture) {
		super(xPosition, yPosition, givenWidth, givenHeight, givenTexture);
		isDead = false;
		health = 100;
	}

	public int getHealth(){
		return health;
	}

	public void damageHealth(int damage){
		health -= damage;
		if(health <= 0){
			isDead = true;
		}
	}

	public boolean isDead(){
		return isDead;
	}
}
