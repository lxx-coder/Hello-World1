package com.example;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class JavaFXExample extends Application{
	public JavaFXExample(){
//		System.out.println("Test2");
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		System.out.println("Test1");
//		Application.launch(args);
//	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("Test3");
//		Button btOK = new Button("OK");
//		btOK.setStyle("-fx-border-color:blue");
		Circle circle = new Circle();
		circle.setRadius(50);
		circle.setStroke(Color.BLACK);
		circle.setFill(new Color(0.5, 0.5, 0.5, 1));
		circle.setFill(Color.LIGHTBLUE);
		
		Label label = new Label("JavaFX");
		label.setFont(Font.font("Times New Roman",
				FontWeight.BOLD,FontPosture.ITALIC,20));
		
		Pane pane = new StackPane();
		pane.getChildren().add(circle);
		pane.getChildren().add(label);
//		pane.setRotate(45);
//		pane.setStyle("-fx-border-color:red;-fx-background-color:lightgray;");
		Scene scene = new Scene(pane,200,250);
		primaryStage.setTitle("MyJavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


}
