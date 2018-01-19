package com.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Client extends Application{
	DataOutputStream toServer = null;
	DataInputStream fromServer = null;
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane paneForTextfield = new BorderPane();
		paneForTextfield.setPadding(new Insets(5,5,5,5));
		paneForTextfield.setStyle("-fx-border-color:green");
		paneForTextfield.setLeft(new Label("Enter a radius: "));
		
		TextField tf = new TextField();
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		paneForTextfield.setCenter(tf);
		
		BorderPane mainPane = new BorderPane();
		TextArea ta = new TextArea();
		mainPane.setCenter(new ScrollPane(ta));
		mainPane.setTop(paneForTextfield);
		
		Scene scene = new Scene(mainPane,450,200);
		primaryStage.setTitle("Client");
		primaryStage.setScene(scene);;
		primaryStage.show();
		
		tf.setOnAction(e->{
			try{
				double radius = Double.parseDouble(tf.getText().trim());
				toServer.writeDouble(radius);
				toServer.flush();
				
				double area = fromServer.readDouble();
				ta.appendText("Radius is "+radius+"\n");
				ta.appendText("Area received from the server is "+ area+'\n');
			}catch(IOException ex){
				System.err.println(ex);
			}
		});
		try{
			Socket socket = new Socket("localhost",8000);
			System.out.println("local port: "+socket.getLocalPort());
			fromServer = new DataInputStream(socket.getInputStream());
			toServer = new DataOutputStream(socket.getOutputStream());
			toServer = new DataOutputStream(socket.getOutputStream());
		}catch(IOException ex){
			ta.appendText(ex.toString()+'\n');
		}
	}

}
