package com.exercise.demo;

public class test4_6 {

	public static void main(String[] args) {
		double arc1 = Math.random()*2*Math.PI;
		double arc2,arc3;
		while((arc2 = Math.random()*2*Math.PI)== arc1);
		while((arc3 = Math.random()*2*Math.PI)== arc1 || arc3 == arc2);
		
		double radius = 40;
		
		double x1 = radius*Math.cos(arc1);
		double y1 = radius*Math.sin(arc1);
		double x2 = radius*Math.cos(arc2);
		double y2 = radius*Math.sin(arc2);
		double x3 = radius*Math.cos(arc3);
		double y3 = radius*Math.sin(arc3);
		
		double a = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		double b = Math.sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));
		double c = Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
		
		double angle1 = Math.acos((a*a+b*b-c*c)/(2*a*b));
		double angle2 = Math.acos((a*a+c*c-b*b)/(2*a*c));
		double angle3 = Math.acos((c*c+b*b-a*a)/(2*c*b));
		
		System.out.printf("The three angle2 are: %.2f, %.2f, %.2f",
		angle1*180/Math.PI,angle2*180/Math.PI,angle3*180/Math.PI);
	}

}
