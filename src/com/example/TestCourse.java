package com.example;

public class TestCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course course1 = new Course("Data Structures");
		Course course2 = new Course("Database Systems");
		
		course1.addStudent("Peter Jones");
		course1.addStudent("Brian Smith");
		course1.addStudent("Anne Kenndy");
	
		course2.addStudent("Peter Jones");
		course2.addStudent("Steve Smith");
		
		System.out.println("Number of student in course1:"
				+ course1.getNumberOfStudents());
		String[] students = course1.getStudent();
		for (int i = 0; i < course1.getNumberOfStudents(); i++) {
			System.out.print(students[i] + ", ");
		}
		System.out.println();
		System.out.println("Number of students in course2: " +
				course2.getNumberOfStudents());
	}

}
