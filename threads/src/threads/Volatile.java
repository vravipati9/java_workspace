package threads;

import java.util.Scanner;

class TestVolatile extends Thread {
	private boolean running = true;
	public void run() {
		while(running) {
			System.out.println("Hello!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutDown() {
		System.out.println("Stopping Thread");
		running = false;
	}
}

public class Volatile {
	private static volatile boolean running = false;

	public static void main(String a[]) throws InterruptedException {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// wait for running to become true
				while(!running) {}
				System.out.println("Started.");
				// wait for running to become false
				while(running) {}
				System.out.println("Stopped.");
				
			}
		}).start();
		
		// wait one second
		Thread.sleep(1000);
		System.out.println("Starting...");
		
		// Set running to true
		running = true;
		
		// wait one second
		Thread.sleep(1000);
		System.out.println("Stoppping...");
		
		//set runnig to true
		running  = false;
	}
}
