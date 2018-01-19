package com.example;

import java.util.Scanner;
import java.io.*;

public class FileNotFoundExceptionDemo {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner inputFromConsolo = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String filename = inputFromConsolo.nextLine();
		
		try{
			Scanner inputFromFile = new Scanner(new File(filename));
			System.out.println("File " + filename + " exists!");
			while(inputFromFile.hasNext()){
				System.out.println(inputFromFile.nextLine());
			}
			inputFromFile.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("Exception: " + filename + " not found");
		}
	}

}
