package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class AIcharacter  {
	private Pane root;
	
	private List<Node> enemies = new ArrayList<>();

	public Node spawnLaser(){
		Rectangle enemy = new Rectangle(160,340, Color.RED);
		enemy.setTranslateY((int)(Math.random()*14)*40);
		
		root.getChildren().add(enemy);
		return enemy;
		
	}
	public void onUpdate(){
		for(Node enemy : enemies)
			enemy.setTranslateX(enemy.getTranslateX()+Math.random()*10);
		if(Math.random() < 0.045) {
			enemies.add(spawnLaser());
		}
		
	}
	
	
}
