package charactersAndObjects;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class BackgroundObject {
	private Image background;
	private ArrayList<GameObject> backObjects;
	private ArrayList<MovableObject> backMovingObjects;
	private ArrayList<GameObject> doors;

	public BackgroundObject(Image givenBackground){
		background = givenBackground;
	}

	public ArrayList<CollisionBox> getBoxLocations(){
		ArrayList<CollisionBox> boxes = new ArrayList<CollisionBox>();
		for(int i = 0; i < backObjects.size(); i++){
			boxes.add(backObjects.get(i).getCollisionBox());
		}
		for(int j = 0; j < backMovingObjects.size(); j++){
			boxes.add(backMovingObjects.get(j).getCollisionBox());
		}
		return boxes;
	}

	public Image getBackgroundImage(){
		return background;
	}

	public void addGameObject(GameObject objToAdd){
		backObjects.add(objToAdd);
	}

	public void addGameObject(ArrayList<GameObject> objsToAdd){
		backObjects.addAll(objsToAdd);
	}

	public void addMovingObject(MovableObject mObj){
		backMovingObjects.add(mObj);
	}

	public void addMovingObject(ArrayList<MovableObject> mObjs){
		backMovingObjects.addAll(mObjs);
	}

	public void resetMovingObjects(){
		backMovingObjects.clear();
	}

	public ArrayList<GameObject> getGameObjects(){
		return backObjects;
	}

	public void setGameObjects(ArrayList<GameObject> gameObjects){
		backObjects = gameObjects;
	}

	public ArrayList<MovableObject> getMovableObjects(){
		return backMovingObjects;
	}

	public void setMovableObjects(ArrayList<MovableObject> movableObjects){
		backMovingObjects = movableObjects;
	}

	public ArrayList<GameObject> getDoors(){
		return doors;
	}

	public void setDoors(ArrayList<GameObject> doorList){
		doors = doorList;
	}

	public void addDoors(ArrayList<GameObject> doorList){
		doors.addAll(doorList);
	}

	public void addDoors(GameObject doorToAdd){
		doors.add(doorToAdd);
	}
}
