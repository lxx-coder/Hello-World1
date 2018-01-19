package com.thread.demo;

public class JavaThreadCreateionAndRun {
	public static void main(String[] args) {
		System.out.println("The main method was executed by thread:"
				+ Thread.currentThread().getName());
		Helper helper = new Helper("Java Thread Anywhere");
		
		Thread thread = new Thread(helper);
//		thread.setName("A-Worker-Thread");
		thread.start();
		
	}
	
	
	static class Helper implements Runnable{
		private final String message;
		
		public Helper(String message){
			this.message=message;
		}
		
		private void doSomething(String message){
			System.out.println("The doSomething nethod was executed by thread:"
					+ Thread1.currentThread().getName());
			System.out.println("Do spmething with "+message);
		}

		@Override
		public void run() {
			doSomething(message);			
		}		
	}
}
