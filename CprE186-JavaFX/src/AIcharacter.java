package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class AIcharacter extends Application {
	private Pane root;
	
	private List<Node> enemies = new ArrayList<>();
	private AnimationTimer timer;
	
	private Parent createContent() {
			 root = new Pane();
			 root.setPrefSize(1920, 1080);
			 
			 
			 timer = new AnimationTimer() {
				 @Override
				 public void handle(long now) {
					 onUpdate();
				 }
			 };
			
			 timer.start();
			return root;
			
			
	}
	private Node spawnCharacter(){
		Rectangle enemy = new Rectangle(160,340, Color.RED);
		enemy.setTranslateY((int)(Math.random()*14)*40);
		
		root.getChildren().add(enemy);
		return enemy;
		
	}
	private void onUpdate() {
		for(Node enemy : enemies)
			enemy.setTranslateX(enemy.getTranslateX()+Math.random()*10);
		if(Math.random() < 0.045) {
			enemies.add(spawnCharacter());
		}
		checkState();
		
	}
	
	private void checkState() {
		for(Node enemy : enemies) {
			if(enemy.getBoundsInParent().intersects(.getBoundsInParent())) {
				enemy.setTranslateX(650);
				enemy.setTranslateY(875);
				return;
			}
		}
	}
	
	@Override
	public void start(Stage scene) throws Exception {
		scene.setScene(new Scene(createContent()));
		
		scene.show();// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
