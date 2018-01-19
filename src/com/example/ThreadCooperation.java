package com.example;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ThreadCooperation {
	private static Account account = new Account();
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new WithdrawTask());
		executor.execute(new DepositTask());
		executor.shutdown();
		
		System.out.println("Thread 1\t\t Thread2\t\tBalance");

	}
	
	public static class DepositTask implements Runnable{

		@Override
		public void run() {
			try{
				while(true){
					account.deposit((int)(Math.random()*10)+1);
					Thread.sleep(1000);
					
				}
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}		
	}
	public static class WithdrawTask implements Runnable{

		@Override
		public void run() {
			while(true){
				account.withdraw((int)(Math.random()*10)+1);
			}
		}		
	}
	
	private static class Account{
		private static Lock lock = new ReentrantLock();
		
		private static Condition newDeposit = lock.newCondition();
		private int balance = 0;
		public int getBalance(){
			return balance;
		}
		public void withdraw(int amount){
			lock.lock();
			try {
				while(balance<amount){
					System.out.println("\t\tWait for a deposit");
					newDeposit.await();
				}
				
				balance -=amount;
				System.out.println("\t\tWithdraw "+amount+"\t\t"+getBalance());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}
		public void deposit(int amount){
			lock.lock();
			try {
				balance += amount;
				System.out.println("Deposit "+amount+"\t\t\t\t\t"+getBalance());
				newDeposit.signalAll();
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				lock.unlock();
			}
		}
	}

}
