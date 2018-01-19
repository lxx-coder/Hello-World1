package com.newcoder.solution;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleErrorRecord {

	public static void main(String[] args) {
		ArrayList<String> pathList = new ArrayList<String>();
		ArrayList<Integer> lineList = new ArrayList<Integer>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String path = input.next();
			int line = input.nextInt();
			String[] tmp = path.split("\\");
			path = tmp[tmp.length-1];
			if(pathList.contains(path)){
				int index = pathList.indexOf(path);
				if(lineList.get(index) == line){
					
				}
			}
		}
	}

}
