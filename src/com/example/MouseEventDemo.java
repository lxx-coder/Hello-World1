package com.example;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class MouseEventDemo extends Application{
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new Pane();
		Text text = new Text(20,20,"Programming is fun");
		pane.getChildren().addAll(text);
		text.setOnMouseDragged(e->{
			text.setX(e.getX());
			text.setY(e.getY());
		});
		Scene scene = new Scene(pane,300,100);
		primaryStage.setTitle("MouseEventDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
