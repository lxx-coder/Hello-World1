package com.exercise.demo;

import java.util.Scanner;

public class test4_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter point 1 (latitude and longitude) in degrees:");
		String tmp1 = input.nextLine();
		String[] tmpArray1 = tmp1.split(",");
		double x1 = Double.parseDouble(tmpArray1[0]);
		double y1 = Double.parseDouble(tmpArray1[1]);
		System.out.println("Enter point 2 (latitude and longitude) in degrees:");
		String tmp2 = input.nextLine();
		String[] tmpArray2 = tmp2.split(",");
		double x2 = Double.parseDouble(tmpArray2[0]);
		double y2 = Double.parseDouble(tmpArray2[1]);
		input.close();
		
		double radius = 6371.01;
		double d = radius * Math.acos(Math.sin(x1)*Math.sin(x2)+Math.cos(x1)*Math.cos(x2)*Math.cos(y1-y2));
		System.out.println("The distance between the points is "+d+" km");
	}

}
