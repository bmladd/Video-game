package items;

import inanimateObjects.GameObject;
import javafx.scene.image.Image;

public class Weapon extends GameObject{
	private double damage;
	private String name;

	public Weapon(Image givenTexture, double givenDamage){
		super(givenTexture);
		damage = givenDamage;
		name = "";
	}

	public Weapon(Image givenTexture, double givenDamage, String givenName){
		super(givenTexture);
		damage = givenDamage;
		name = givenName;
	}

	public Weapon(Image givenTexture, String givenName){
		super(givenTexture);
		damage = 10;
		name = givenName;
	}

	public Weapon(Image givenTexture){
		super(givenTexture);
		damage = 10;
		name = "";
	}

	public double getDamage(){
		return damage;
	}

	public void setName(String newName){
		name = newName;
	}

	public String getName(){
		return name;
	}
}
