package com.example;

public class Rectangle extends GeometricObject1 {
	private double width;
	private double height;
	
	public  Rectangle() {
	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public Rectangle(Double width, Double height, String color, boolean filled) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
		setColor(color);
		setFilled(filled);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getArea() {
		return width * height; 
	}
	
	public double getPerimeter() {
		return 2 * (width * height);
	}
	
	
}
