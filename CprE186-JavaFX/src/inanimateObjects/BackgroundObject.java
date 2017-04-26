package inanimateObjects;

import java.util.ArrayList;

import items.Weapon;
import javafx.scene.image.Image;
import otherCharacters.NonPlayerCharacter;
import playerCharacter.PlayerCharacter;

public class BackgroundObject {
	private Image background;
	private ArrayList<ImmovableObject> backObjects;
	private ArrayList<MovableObject> backMovingObjects;
	private ArrayList<CollisionBox> cBoxes;
	private ArrayList<CollisionBox> doors;
	private ArrayList<CollisionBox> doorsExt;
	private ArrayList<NonPlayerCharacter> npcs;

	public BackgroundObject(Image givenBackground) {
		background = givenBackground;
		backObjects = new ArrayList<ImmovableObject>();
		backMovingObjects = new ArrayList<MovableObject>();
		cBoxes = new ArrayList<CollisionBox>();
		doors = new ArrayList<CollisionBox>();
		doorsExt = new ArrayList<CollisionBox>();
		npcs = new ArrayList<NonPlayerCharacter>();

	}

	public void setTexture(Image givenBackground){
		background = givenBackground;
	}

	public ArrayList<CollisionBox> getAllBoxLocations() {
		ArrayList<CollisionBox> boxes = new ArrayList<CollisionBox>();
		for (int i = 0; i < backObjects.size(); i++) {
			boxes.add(backObjects.get(i).getCollisionBox());
		}
		for (int j = 0; j < backMovingObjects.size(); j++) {
			boxes.add(backMovingObjects.get(j).getCollisionBox());
		}
		boxes.addAll(cBoxes);
		return boxes;
	}

	public void addCollisionBoxes(CollisionBox givenBox) {
		cBoxes.add(givenBox);
	}

	public void addCollisionBoxes(ArrayList<CollisionBox> givenBox) {
		cBoxes.addAll(givenBox);
	}

	public Image getBackgroundImage() {
		return background;
	}

	public void addGameObject(ImmovableObject objToAdd) {
		backObjects.add(objToAdd);
	}

	public void addGameObject(ArrayList<ImmovableObject> objsToAdd) {
		backObjects.addAll(objsToAdd);
	}

	public void addMovingObject(MovableObject mObj) {
		backMovingObjects.add(mObj);
	}

	public void addMovingObject(ArrayList<MovableObject> mObjs) {
		backMovingObjects.addAll(mObjs);
	}

	public void resetMovingObjects() {
		backMovingObjects.clear();
	}

	public ArrayList<ImmovableObject> getGameObjects() {
		return backObjects;
	}

	public void setGameObjects(ArrayList<ImmovableObject> gameObjects) {
		backObjects = gameObjects;
	}

	public ArrayList<MovableObject> getMovableObjects() {
		return backMovingObjects;
	}

	public void setMovableObjects(ArrayList<MovableObject> movableObjects) {
		backMovingObjects = movableObjects;
	}

	public ArrayList<CollisionBox> getDoors() {
		return doors;
	}

	public void setDoors(ArrayList<CollisionBox> doorList) {
		doors = doorList;
	}

	public void addDoors(ArrayList<CollisionBox> doorList) {
		doors.addAll(doorList);
	}

	public void addDoors(CollisionBox doorToAdd) {
		doors.add(doorToAdd);
	}

	public ArrayList<CollisionBox> getDoorsExtended() {
		return doorsExt;
	}

	public void setDoorsExtended(ArrayList<CollisionBox> doorsExt) {
		this.doorsExt = doorsExt;
	}

	public void addDoorsExtended(ArrayList<CollisionBox> doorList) {
		doorsExt.addAll(doorList);
	}

	public void addDoorsExtended(CollisionBox doorToAdd) {
		doorsExt.add(doorToAdd);
	}

	public void setNPCs(ArrayList<NonPlayerCharacter> givenNPCs){
		npcs = givenNPCs;
	}

	public void addNPC(ArrayList<NonPlayerCharacter> givenNPCs){
		npcs.addAll(givenNPCs);
	}

	public void addNPC(NonPlayerCharacter givenNPC){
		npcs.add(givenNPC);
	}

	public ArrayList<NonPlayerCharacter> getNPCs(){
		return npcs;
	}

	public ArrayList<CollisionBox> getNPCCollisions(){
		ArrayList<CollisionBox> npcBoxes = new ArrayList<CollisionBox>();
		for(int i = 0; i < npcs.size(); i++){
			npcBoxes.add(npcs.get(i).getCollisionBox());
		}
		return npcBoxes;
	}

	public void hitNPCs(Weapon givenWeapon){
		for(int i = 0; i < npcs.size(); i++){
			if(givenWeapon.getCollisionBox().isColliding(npcs.get(i).getCollisionBox())){
				npcs.get(i).damageHealth(givenWeapon.getDamage());
			}
		}
	}

	public void handleNPCs(PlayerCharacter pc){
		for(int i = 0; i < npcs.size(); i++){
			npcs.get(i).handle(pc, getAllBoxLocations());
		}
	}
}
