package com.exercise.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import sun.java2d.cmm.kcms.KcmsServiceProvider;

public class test22_8 {
	public final static long N = 10000000000L;
	public final static int M = 10000;
	public static ArrayList<Integer> primeList = new ArrayList<Integer>();
	public static int count = 1;
	File file = new File("PrimeNumber.dat");
	
	public test22_8() {
		primeList.add(2);
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(String.valueOf(primeList.get(0)) + " ");
			writer.flush();
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {		
		long number = 3;
		int squareRoot = 2;
		
		while(number < N){
			boolean prime = true;
			if(squareRoot * squareRoot < number)squareRoot++;
			
		}
		
		
	}
	
	public static boolean isPrime(long number,int squareRoot,ArrayList<Integer> list){
		boolean prime = true;
		for(int k = 0;k < list.size() && list.get(k) < squareRoot;k++){
			if(number % list.get(k) == 0){
				prime = false;
				break;
			}
		}
		return prime;

	}

}
