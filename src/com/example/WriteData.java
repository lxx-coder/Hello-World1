package com.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.PrintWriter;

public class WriteData {

	public static void main(String[] args) throws IOException {
		File file = new File("D:/scores.txt");
		
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			writer.write("John T Smith ");
			writer.write(String.valueOf(90));
			writer.flush();
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
