package otherCharacters;

import java.util.ArrayList;

import inanimateObjects.CollisionBox;
import inanimateObjects.MovableObject;
import items.Weapon;
import items.WeaponList;
import javafx.scene.image.Image;
import levelConstants.Constants;
import playerCharacter.PlayerCharacter;

public class NonPlayerCharacter extends MovableObject {
	protected double health;
	protected boolean isDead;
	protected boolean facingLeft;
	protected boolean attacking;
	protected Weapon weap;
	protected int timeCtr;

	public NonPlayerCharacter(CollisionBox givenBox, Image givenTexture) {
		super(givenBox, givenTexture);
		isDead = false;
		health = 100;
		facingLeft = true;
		attacking = false;
		weap = WeaponList.DefaultWeapon;
	}

	public NonPlayerCharacter(int xPosition, int yPosition, Image givenTexture) {
		super(xPosition, yPosition, givenTexture);
		isDead = false;
		health = 100;
		facingLeft = true;
		attacking = false;
		weap = WeaponList.DefaultWeapon;
	}

	public NonPlayerCharacter(Image givenTexture) {
		super(givenTexture);
		isDead = false;
		health = 100;
		facingLeft = true;
		attacking = false;
		weap = WeaponList.DefaultWeapon;
	}

	public NonPlayerCharacter(int xPosition, int yPosition, int givenWidth, int givenHeight, Image givenTexture) {
		super(xPosition, yPosition, givenWidth, givenHeight, givenTexture);
		isDead = false;
		health = 100;
		facingLeft = true;
		attacking = false;
		weap = WeaponList.DefaultWeapon;
	}

	public double getHealth() {
		return health;
	}

	public void damageHealth(double damage) {
		health -= damage;
		if (health <= 0) {
			isDead = true;
		}
	}

	public boolean isDead() {
		return isDead;
	}

	public void handle(PlayerCharacter pc, ArrayList<CollisionBox> boxes) {
		timeCtr++;
		facingLeft = this.getTopLeftX() < pc.getTopLeftX();
		if (Math.abs(this.getTopLeftX() - pc.getTopLeftX()) > Constants.EnemyTolerance) {
			attacking = false;
			if (this.getTopLeftX() > pc.getTopLeftX()) {
				this.moveToPosition(boxes, -Constants.EnemyMove, 0);
			}
			if (this.getTopLeftX() < pc.getTopLeftX()) {
				this.moveToPosition(boxes, Constants.EnemyMove, 0);
			}
		}
		else if(Math.abs(this.getTopLeftX() - pc.getTopLeftX()) < Constants.EnemyAttackTolerance){
			if(timeCtr > Constants.EnemyTimeBetweenAttack){
				attacking = true;
				timeCtr = 0;
			}
			else{
				attacking = false;
			}
		}
		else{
			attacking = false;
		}
		if (Math.abs(this.getTopLeftY() - pc.getTopLeftY()) > Constants.EnemyTolerance) {
			if (this.getTopLeftY() > pc.getTopLeftY()) {
				this.moveToPosition(boxes, 0, -Constants.EnemyMove);
			}
			if (this.getTopLeftY() < pc.getTopLeftY()) {
				this.moveToPosition(boxes, 0, Constants.EnemyMove);
			}
		}
	}

	public boolean facingLeft(){
		return facingLeft;
	}

	public boolean isAttacking(){
		return attacking;
	}

	public Weapon getWeapon(){
		return weap;
	}

	public void setWeapon(Weapon givenWeapon){
		weap = givenWeapon;
	}
}
