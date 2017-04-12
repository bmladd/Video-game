package levelConstants;

import java.util.ArrayList;

import charactersAndObjects.CollisionBox;
import javafx.scene.image.Image;

public class Constants {
	public static final int HERO_OFFSET = 10;

	public static Image Courtyard = new Image("file:JavaFXGameMaps/Courtyard.png");
	public static ArrayList<CollisionBox> getCourtyardCollisions() {
		CollisionBox CBox1 = new CollisionBox(176, 140, 120, 95);
		CollisionBox CBox2 = new CollisionBox(262, 441, 120, 95);
		CollisionBox CBox3 = new CollisionBox(573, 255, 120, 95);
		CollisionBox CBox4 = new CollisionBox(675, 552, 120, 95);
		ArrayList<CollisionBox> boxes = new ArrayList<CollisionBox>();
		boxes.add(CBox1);
		boxes.add(CBox2);
		boxes.add(CBox3);
		boxes.add(CBox4);
		return boxes;
	}
	public static ArrayList<CollisionBox> getCourtyardDoors() {
		CollisionBox CDoor1 = new CollisionBox(0, 260, 24, 128);
		CollisionBox CDoor2 = new CollisionBox(1000, 49, 24, 128);
		ArrayList<CollisionBox> doors = new ArrayList<CollisionBox>();
		doors.add(CDoor1);
		doors.add(CDoor2);
		return doors;
	}


	public static Image Mountain = new Image("file:JavaFXGameMaps/Mountain.png");

	public static Image ForestLake = new Image("file:JavaFXGameMaps/ForestLake.png");
	public static ArrayList<CollisionBox> getForestLakeCollisions() {
		CollisionBox FBox1 = new CollisionBox(172, 168, 420, 36);
		CollisionBox FBox2 = new CollisionBox(350, 250, 300, 238);
		ArrayList<CollisionBox> boxes = new ArrayList<CollisionBox>();
		boxes.add(FBox1);
		boxes.add(FBox2);
		return boxes;
	}
	public static ArrayList<CollisionBox> getForestLakeDoors() {
		CollisionBox FDoor1 = new CollisionBox(0, 380, 24, 128);
		CollisionBox FDoor2 = new CollisionBox(1000, 190, 24, 128);
		ArrayList<CollisionBox> doors = new ArrayList<CollisionBox>();
		doors.add(FDoor1);
		doors.add(FDoor2);
		return doors;
	}

	public static Image Temple = new Image("file:JavaFXGameMaps/Temple.png");
	public static CollisionBox[] TempleDoors = { new CollisionBox(0, 72, 24, 128),
			new CollisionBox(1000, 569, 24, 128) };

	public static Image Options = new Image("file:JavaFXGameMaps/GameOver");
	public static Image TitleScreen = new Image("file:JavaFXGameMaps/TitleScreen.png");






}
