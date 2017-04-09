package charactersAndObjects;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class BackgroundObject {
	private Image background;
	private ArrayList<GameObject> backObjects;
	private ArrayList<MovableObject> backMovingObjects;
	private ArrayList<CollisionBox> cBoxes;
	private ArrayList<CollisionBox> doors;

	public BackgroundObject(Image givenBackground) {
		background = givenBackground;
		backObjects = new ArrayList<GameObject>();
		backMovingObjects = new ArrayList<MovableObject>();
		cBoxes = new ArrayList<CollisionBox>();
		doors = new ArrayList<CollisionBox>();
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

	public void addGameObject(GameObject objToAdd) {
		backObjects.add(objToAdd);
	}

	public void addGameObject(ArrayList<GameObject> objsToAdd) {
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

	public ArrayList<GameObject> getGameObjects() {
		return backObjects;
	}

	public void setGameObjects(ArrayList<GameObject> gameObjects) {
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
}
