package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class EfficientPrimeNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please input a number:");
		int n = input.nextInt();
		input.close();
		
		ArrayList<Integer> list = new ArrayList<>();
		int squareRoot = 1;
		int number = 2;
		
		
		while(number <= n){
			if(squareRoot * squareRoot < number)squareRoot++;
			boolean isPrime = true;
			
			for(int k = 0;k < list.size() && k < squareRoot;k++){
				if(number % list.get(k) == 0){
					isPrime = false;
					break;
				}
			}
			
			if(isPrime){
				list.add(number);
				System.out.printf("%3d ",list.get(list.size()-1));
				if(list.size() % 10 == 0)
					System.out.println("\n");
			}
			number++;
		}
	}
}
