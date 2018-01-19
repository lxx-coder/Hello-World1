package com.exercise.demo;

import java.util.Scanner;

public class test22_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string s1:");
		String s1 = input.nextLine();
		System.out.print("Enter a string s2:");
		String s2 = input.nextLine();
		input.close();
		
		int index = -1;
		for(int i = 0;i < s1.length() - s2.length();i++){
			if(s1.charAt(i) == s2.charAt(0) || s1.regionMatches(i, s2, 0, s2.length())){
				index = i;
			}
		}
		if(index < 0){
			System.out.println("There is no match!");
		}else{
			System.out.println("match at index "+ index);
		}
		
	}
}
