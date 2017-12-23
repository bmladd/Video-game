package otherCharacters;

import java.util.ArrayList;

import inanimateObjects.CollisionBox;
import items.Weapon;
import playerCharacter.PlayerCharacter;

public interface NonPlayerCharacter {

	double getHealth();

	void damageHealth(double damage);

	boolean isDead();

	void handle(PlayerCharacter pc, ArrayList<CollisionBox> boxes);

	boolean facingLeft();

	boolean isAttacking();

	Weapon getWeapon();

	void setWeapon(Weapon givenWeapon);

}