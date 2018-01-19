package com.example;
import java.util.*;

public class GeometricObject1 {
	private String color = "while";
	private boolean filled;
	private Date dateCreated;
	
	public GeometricObject1() {
		dateCreated = new Date();
	}

	public GeometricObject1(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
		dateCreated = new Date();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public Date getDateCtreated() {
		return dateCreated;
	}
	
	public String toString(){
		return "create on " + dateCreated + "\ncolor: "
				+ color + " and filled: " + filled;
	}
	
	
	
}
