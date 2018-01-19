package com.example;

public class TestException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			System.out.println(sum(new int[]{1,2,3,4,5}));
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("\n" + ex.getMessage());
			System.out.println("\n" + ex.toString());
			
			System.out.println("\nTrack Info Obtained from getStackTrack");
			StackTraceElement[] trackElements = ex.getStackTrace();
			for(int i = 0;i < trackElements.length; i++){
				System.out.print("method " + trackElements[i].getMethodName());
				System.out.print("(" + trackElements[i].getClassName() + ":");
				System.out.println(trackElements[i].getLineNumber() + ")");
			}
		}
	}
	private static int sum(int[] list) {
		int result = 0;
		for (int i = 0; i <= list.length; i++)
			result += list[i];
		return result;
	}
}
