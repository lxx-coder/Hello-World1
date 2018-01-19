package com.newcoder.solution;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int[] score = new int[N];
		for(int i = 0;i < N;i++){
			score[i] = input.nextInt();
		}
		
		ArrayList<Integer> resultsList = new ArrayList<Integer>();
//		input.nextLine();
		for(int k = 0;k < M;k++){
			char C = input.next().charAt(0);
			int A = input.nextInt();
			int B = input.nextInt();
			if('U' == C){
				if(A>0 && A <= N){
					score[A-1] = B;
				}
			}else if('Q' == C){
				if(A>B){
					int x =  A;
					A = B;
					B = x;
				}
				if(A>0  && B<=N){
					int max = score[A-1];
					for(int i = A;i < B;i++){
						if(max < score[i])
							max = score[i];
					}
					resultsList.add(max);
				}
			}
		}
		input.close();
		for(int a:resultsList){
			System.out.println(a);
		}
	}
}
