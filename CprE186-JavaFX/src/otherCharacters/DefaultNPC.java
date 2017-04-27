package otherCharacters;

import java.util.ArrayList;

import inanimateObjects.CollisionBox;
import inanimateObjects.MovableObject;
import items.Weapon;
import items.WeaponList;
import javafx.scene.image.Image;
import levelConstants.Constants;
import playerCharacter.PlayerCharacter;

public class DefaultNPC extends MovableObject implements NonPlayerCharacter {
	protected double health;
	protected boolean isDead;
	protected boolean facingLeft;
	protected boolean attacking;
	protected Weapon weap;
	protected int timeCtr;

	public DefaultNPC(CollisionBox givenBox, Image givenTexture) {
		super(givenBox, givenTexture);
		isDead = false;
		health = 100;
		facingLeft = true;
		attacking = false;
		weap = WeaponList.DefaultWeapon;
	}

	public DefaultNPC(int xPosition, int yPosition, Image givenTexture) {
		super(xPosition, yPosition, givenTexture);
		isDead = false;
		health = 100;
		facingLeft = true;
		attacking = false;
		weap = WeaponList.DefaultWeapon;
	}

	public DefaultNPC(Image givenTexture) {
		super(givenTexture);
		isDead = false;
		health = 100;
		facingLeft = true;
		attacking = false;
		weap = WeaponList.DefaultWeapon;
	}

	public DefaultNPC(int xPosition, int yPosition, int givenWidth, int givenHeight, Image givenTexture) {
		super(xPosition, yPosition, givenWidth, givenHeight, givenTexture);
		isDead = false;
		health = 100;
		facingLeft = true;
		attacking = false;
		weap = WeaponList.DefaultWeapon;
	}

	/* (non-Javadoc)
	 * @see otherCharacters.NonPlayerCharacter#getHealth()
	 */
	@Override
	public double getHealth() {
		return health;
	}

	/* (non-Javadoc)
	 * @see otherCharacters.NonPlayerCharacter#damageHealth(double)
	 */
	@Override
	public void damageHealth(double damage) {
		health -= damage;
		if (health <= 0) {
			isDead = true;
		}
	}

	/* (non-Javadoc)
	 * @see otherCharacters.NonPlayerCharacter#isDead()
	 */
	@Override
	public boolean isDead() {
		return isDead;
	}

	/* (non-Javadoc)
	 * @see otherCharacters.NonPlayerCharacter#handle(playerCharacter.PlayerCharacter, java.util.ArrayList)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see otherCharacters.NonPlayerCharacter#facingLeft()
	 */
	@Override
	public boolean facingLeft(){
		return facingLeft;
	}

	/* (non-Javadoc)
	 * @see otherCharacters.NonPlayerCharacter#isAttacking()
	 */
	@Override
	public boolean isAttacking(){
		return attacking;
	}

	/* (non-Javadoc)
	 * @see otherCharacters.NonPlayerCharacter#getWeapon()
	 */
	@Override
	public Weapon getWeapon(){
		return weap;
	}

	/* (non-Javadoc)
	 * @see otherCharacters.NonPlayerCharacter#setWeapon(items.Weapon)
	 */
	@Override
	public void setWeapon(Weapon givenWeapon){
		weap = givenWeapon;
	}
}
