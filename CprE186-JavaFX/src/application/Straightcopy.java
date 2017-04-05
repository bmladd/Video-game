package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Straightcopy extends Application{
	
	public Stage window;
	public Scene scene1, scene2, scene3;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primarystage) throws Exception {
		window = primarystage;

		// Images
		Image space = new Image("file:Courtyard.png");
		Image space2 = new Image("file:Mountain.png");
		Image TitleScreen = new Image("file:TitleScreen.png");

		// Button1
		Button B = new Button("Quit");
		B.setLayoutX(0);
		B.setLayoutY(0);
		B.setOnAction(e -> window.setScene(scene2));
		// Button1Copy
		Button BC = new Button("Quit");
		BC.setLayoutX(0);
		BC.setLayoutY(0);
		BC.setOnAction(e -> window.setScene(scene2));

		// Button3
		Button B3 = new Button("Options");
		B3.setLayoutX(430);
		B3.setLayoutY(580);
		B3.setPrefSize(160, 60);
		B3.setOnAction(e -> window.setScene(scene3));
		// Button2
		Button B2 = new Button("Play");
		B2.setLayoutX(430);
		B2.setLayoutY(500);
		B2.setPrefSize(160, 60);
		B2.setOnAction(e -> window.setScene(scene1));

		// Layout1
		Group root = new Group();
		Canvas canvas = new Canvas(1024, 768);
		root.getChildren().add(canvas);
		root.getChildren().add(BC);

		GraphicsContext gc = canvas.getGraphicsContext2D();

		gc.drawImage(space, 0, 0);
		scene1 = new Scene(root);

		// Layout3
		Group root3 = new Group();
		Canvas canvas3 = new Canvas(1024, 768);
		root3.getChildren().add(canvas3);
		root3.getChildren().add(B3);
		root3.getChildren().add(B);
		GraphicsContext gc3 = canvas3.getGraphicsContext2D();
		gc3.drawImage(space2, 0, 0);
		scene3 = new Scene(root3);

		// Layout2
		Group root2 = new Group();
		Canvas canvas2 = new Canvas(1024, 768);
		root2.getChildren().add(canvas2);
		root2.getChildren().add(B2);
		root2.getChildren().add(B3);
		GraphicsContext gc2 = canvas2.getGraphicsContext2D();
		gc2.drawImage(TitleScreen, 0, 0);
		scene2 = new Scene(root2);

		// end stuff

		window.setScene(scene2);
		window.setTitle("Welcome!");
		window.show();
	}




}