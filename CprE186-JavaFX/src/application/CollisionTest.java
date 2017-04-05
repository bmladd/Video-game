package application;

import java.util.ArrayList;

import charactersAndObjects.CollisionBox;
import charactersAndObjects.MovableObject;

public class CollisionTest {
	public static void main(String[] args) {
		CollisionBox testBox1 = new CollisionBox(1, 1, 2, 4);
		CollisionBox testBox2 = new CollisionBox(4, 2, 3, 3);
		CollisionBox testBox3 = new CollisionBox(1, 2, 2, 2);
		CollisionBox testBox4 = new CollisionBox(5, 3, 1, 1);
		CollisionBox testBox5 = new CollisionBox(1, 6, 7, 5);

		ArrayList<CollisionBox> testBoxes = new ArrayList<CollisionBox>();
		testBoxes.add(testBox1);
		testBoxes.add(testBox2);
		testBoxes.add(testBox3);
		testBoxes.add(testBox4);
		testBoxes.add(testBox5);

		for (int i = 0; i < testBoxes.size(); i++) {
			for (int j = 0; j < testBoxes.size(); j++) {
				if (!testBoxes.get(i).equals(testBoxes.get(j))) {
					if (testBoxes.get(i).isColliding(testBoxes.get(j))) {
						System.out.println("TestBox" + (i + 1) + " is colliding with TestBox" + (j + 1));
					}
				}
			}
		}

		testBoxes.get(2).moveBoxTo(4, 8);
		System.out.println("TestBox1 Position: " + testBoxes.get(0).getTopLeft().toString() + " expected: [1, 1]");
		testBoxes.get(0).translateBoxNoCollisions(testBoxes, 2, 3);
		System.out.println("TestBox1 Position: " + testBoxes.get(0).getTopLeft().toString() + " expected: [2, 3]");
	}
}
