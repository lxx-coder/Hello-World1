package com.example;

public class MyThread implements Runnable{
	private int ticket = 10;
	Object obj = new Object();
	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(true){
//			synchronized (obj) {
//				if(ticket>0){
//					Thread t = Thread.currentThread();
//					try{
//						Thread.sleep(40);
//					}catch(InterruptedException e){
//						e.printStackTrace();
//					}
//					System.out.println(t.getName()+"ticket: "+ticket--);
//				}else{
//					break;
//				}
//			}
//		}
//	}
	synchronized public void run(){
		for(int i = 0;i < 10;i++){
			while(ticket>0){
				System.out.println("³µÆ±£º"+ticket--);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable runnable = new MyThread();
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		Thread t3 = new Thread(runnable);
		t1.start();
		t2.start();
		t3.start();
	}

}
