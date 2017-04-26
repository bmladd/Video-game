package levelConstants;

import java.util.ArrayList;

import inanimateObjects.CollisionBox;
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
		CollisionBox CDoor1 = new CollisionBox(0, 260, 2, 128);
		CollisionBox CDoor2 = new CollisionBox(1000 + (24 - 2), 49, 2, 128);
		ArrayList<CollisionBox> doors = new ArrayList<CollisionBox>();
		doors.add(CDoor1);
		doors.add(CDoor2);
		return doors;
	}

	public static ArrayList<CollisionBox> getCourtyardDoorsExtended() {
		CollisionBox CDoor1 = new CollisionBox(0, 260 + 64, 24, 128 - 64);
		CollisionBox CDoor2 = new CollisionBox(1000, 49 + 64, 24, 128 - 64);
		ArrayList<CollisionBox> doors = new ArrayList<CollisionBox>();
		doors.add(CDoor1);
		doors.add(CDoor2);
		return doors;
	}

	public static ArrayList<CollisionBox> getLevelWalls() {
		CollisionBox lWallTop = new CollisionBox(0, 0, 1024, 24);
		CollisionBox lWallLeft = new CollisionBox(0, 0, 24, 1024);
		CollisionBox lWallRight = new CollisionBox(999, 0, 24, 1024);
		CollisionBox lWallBottom = new CollisionBox(0, 768, 1024, 24);
		ArrayList<CollisionBox> walls = new ArrayList<CollisionBox>();
		walls.add(lWallTop);
		walls.add(lWallLeft);
		walls.add(lWallRight);
		walls.add(lWallBottom);

		return walls;
	}

	public static Image Mountain = new Image("file:JavaFXGameMaps/Mountain.png");


	public static Image ForestLake = new Image("file:JavaFXGameMaps/ForestLake.png");
	
	public static ArrayList<CollisionBox> getForestLakeCollisions() {
		CollisionBox FBox1 = new CollisionBox(172, 168, 420, 36);
		CollisionBox FBox2 = new CollisionBox(430, 500, 420, 36);
		ArrayList<CollisionBox> boxes = new ArrayList<CollisionBox>();
		boxes.add(FBox1);
		boxes.add(FBox2);
		return boxes;
	}
	public static ArrayList<CollisionBox> getForestLakeDoors() {
		CollisionBox FDoor1 = new CollisionBox(0, 380, 2, 128);
		CollisionBox FDoor2 = new CollisionBox(1000 +(24-2), 190, 2, 128);
		ArrayList<CollisionBox> doors = new ArrayList<CollisionBox>();
		doors.add(FDoor1);
		doors.add(FDoor2);
		return doors;
	}
	public static ArrayList<CollisionBox> getForestLakeDoorsExtended() {
		CollisionBox FDoor1 = new CollisionBox(0, 380 + 64, 24, 128 - 64);
		CollisionBox FDoor2 = new CollisionBox(1000, 190 + 64, 24, 128 - 64);
		ArrayList<CollisionBox> doors = new ArrayList<CollisionBox>();
		doors.add(FDoor1);
		doors.add(FDoor2);
		return doors;
	}

	public static Image Temple = new Image("file:JavaFXGameMaps/Temple.png");
	public static ArrayList<CollisionBox> getTempleCollisions() {
		CollisionBox TBox = new CollisionBox(350, 250, 300, 238);
		ArrayList<CollisionBox> boxes = new ArrayList<CollisionBox>();
		return boxes;
	}
	public static ArrayList<CollisionBox> getTempleDoors() {
		CollisionBox TDoor1 = new CollisionBox(0, 72, 2, 128);
		CollisionBox TDoor2 = new CollisionBox(1000 +(24-2), 569, 2, 128);
		ArrayList<CollisionBox> doors = new ArrayList<CollisionBox>();
		doors.add(TDoor1);
		doors.add(TDoor2);
		return doors;
	}
	public static ArrayList<CollisionBox> getTempleDoorsExtended() {
		CollisionBox TDoor1 = new CollisionBox(0, 72 + 64, 24, 128 - 64);
		CollisionBox TDoor2 = new CollisionBox(1000, 569 + 64, 24, 128 - 64);
		ArrayList<CollisionBox> doors = new ArrayList<CollisionBox>();
		doors.add(TDoor1);
		doors.add(TDoor2);
		return doors;
	}
	
	

	public static Image Options = new Image("file:JavaFXGameMaps/GameOver.png");
	public static Image TitleScreen = new Image("file:JavaFXGameMaps/TitleScreen.png");

}
