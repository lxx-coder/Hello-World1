package com.example;

import java.util.concurrent.*;

public class TestThreadDemo {

	public static void main(String[] args) {
//		new Test();
//		Runnable printA = new PrintChar('a', 100);
//		Runnable printB = new PrintChar('b', 100);
//		Runnable print100 = new PrintNum(100);
//		
//		Thread thread1 = new Thread(printA);
//		Thread thread2 = new Thread(printB);
//		Thread thread3 = new Thread(print100);
//		
//		thread2.setPriority(Thread.MAX_PRIORITY);
//		
//		thread1.start();
//		thread2.start();
//		thread3.start();
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.execute(new PrintChar('a', 100));
		executorService.execute(new PrintChar('b', 100));
		executorService.execute(new PrintNum(100));
		
		executorService.shutdown();
	}
}
	
class PrintChar implements Runnable{
	private char charToPrint;
	private int times;
	
	public PrintChar(char c,int t){
		charToPrint = c;
		times = t;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i < times;i++){
			System.out.print(charToPrint);
//			Thread.yield();
		}
	}
}
	
class PrintNum implements Runnable{
	private int lastNum;
	
	public PrintNum(int n){
		lastNum = n;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i <lastNum;i++){
			System.out.print(" "+i);
//			Thread.yield();
		}
	}
}

class Test implements Runnable {
	public Test(){
		Thread thread = new Thread(this);
		thread.start();
//		thread.start();
	}
	
	@Override
	public void run() {
		System.out.println("test");
	}
}
