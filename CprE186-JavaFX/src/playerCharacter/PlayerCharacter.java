package playerCharacter;

import inanimateObjects.CollisionBox;
import inanimateObjects.MovableObject;
import items.WeaponList;
import items.Weapon;
import javafx.scene.image.Image;

public class PlayerCharacter extends MovableObject {
	private Weapon plyrWeapon;

	public PlayerCharacter(CollisionBox givenBox, Image givenTexture) {
		super(givenBox, givenTexture);
		plyrWeapon = WeaponList.DefaultWeapon;
	}

	public PlayerCharacter(int xPosition, int yPosition, Image givenTexture) {
		super(xPosition, yPosition, givenTexture);
		plyrWeapon = WeaponList.DefaultWeapon;
	}

	public PlayerCharacter(Image givenTexture) {
		super(givenTexture);
		plyrWeapon = WeaponList.DefaultWeapon;
	}

	public PlayerCharacter(int xPosition, int yPosition, int givenWidth, int givenHeight, Image givenTexture) {
		super(xPosition, yPosition, givenWidth, givenHeight, givenTexture);
		plyrWeapon = WeaponList.DefaultWeapon;
	}

	public Weapon getWeapon(){
		return plyrWeapon;
	}

	public void setWeapon(Weapon givenWeapon){
		plyrWeapon = givenWeapon;
	}
}
