package com.example;

import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ConsumerProducer {
//	private static Buffer buffer = new Buffer();
	private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<Integer>(2);
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new ProducerTask());
		executor.execute(new ConsumerTask());
		executor.shutdown();
	}
	
	private static class ProducerTask implements Runnable{

		@Override
		public void run() {
			try{
				int i = 1;
				while(true){
					buffer.put(i++);
					System.out.println("Producer writes "+i);
					
					Thread.sleep((int)(Math.random()*10000));
				}
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}	
	}
	
	private static class ConsumerTask implements Runnable{

		@Override
		public void run() {
			try{
				while(true){
					System.out.println("\t\t\tConsumer reads "+buffer.take());
					Thread.sleep((int)(Math.random()*10000));
				}
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
	}
	
	private static class Buffer{
		private static final int CAPACITY = 2;
		private LinkedList<Integer> queue = new LinkedList<Integer>();
		private static Lock lock = new ReentrantLock();
		
		private static Condition notEmpty = lock.newCondition();
		private static Condition notFull = lock.newCondition();
		
		public void write(int value){
			lock.lock();
			try{
				while(queue.size() == CAPACITY){
					System.out.println("Wait for notFull condition");
					notFull.await();
				}
				queue.offer(value);
				notEmpty.signal();
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}finally {
				lock.unlock();
			}
		}
		
		@SuppressWarnings("finally")
		public int read(){
			int value = 0;
			lock.lock();
			try {
				while(queue.isEmpty()){
					System.out.println("\t\t\tWait for notEmpty condition");
					notEmpty.await();
				}
				value = queue.remove();
				notFull.signal();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}finally {
				lock.unlock();
				return value;
			}
		}
	}

}
