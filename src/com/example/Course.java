package com.example;

public class Course {
	private String courseName;
	private String[] students = new String[100];
	private int numberOfStudent;
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	public void addStudent(String student) {
		students[numberOfStudent]=student;
		numberOfStudent++;
	}
	
	public String[] getStudent() {
		return students;
	}
	
	public int getNumberOfStudents() {
		return	numberOfStudent;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void dropStudent(String student) {
		
	}
}
