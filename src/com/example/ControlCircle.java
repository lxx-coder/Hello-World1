package com.example;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application{
	private CirclePane circlePane = new CirclePane();
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
//	System.out.println("Test1");
	Application.launch(args);
}

	@Override
	public void start(Stage primaryStage){
		// TODO Auto-generated method stub
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button btEnlarge = new Button("Enlarge");
		Button btShrink = new Button("Shrink");
		hBox.getChildren().add(btEnlarge);
		hBox.getChildren().add(btShrink);
		
//		btEnlarge.setOnAction(new EnlargeHandler());
//		btShrink.setOnAction(new ShrinkHandler());
		btEnlarge.setOnAction(e -> circlePane.enlarge());
		btShrink.setOnAction(e ->circlePane.shrink());
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(circlePane);
		borderPane.setBottom(hBox);
		BorderPane.setAlignment(hBox, Pos.CENTER);
		
		Scene scene = new Scene(borderPane,200,150);
		primaryStage.setTitle("ControlCircle");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
//	class EnlargeHandler implements EventHandler<ActionEvent>{
//
//		@Override
//		public void handle(ActionEvent event) {
//			// TODO Auto-generated method stub
//			circlePane.enlarge();
//		}
//	}
//	class ShrinkHandler implements EventHandler<ActionEvent>{
//
//		@Override
//		public void handle(ActionEvent event) {
//			// TODO Auto-generated method stub
//			circlePane.shrink();
//		}		
//	}
}

class CirclePane extends StackPane{
	private Circle circle = new Circle(50);
	
	public CirclePane() {
		// TODO Auto-generated constructor stub
		getChildren().add(circle);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
	}
	public void enlarge(){
		circle.setRadius(circle.getRadius() + 2);
	}
	
	public void shrink(){
		circle.setRadius(circle.getRadius() > 2 ?
				circle.getRadius()-2:circle.getRadius());
	}
}
