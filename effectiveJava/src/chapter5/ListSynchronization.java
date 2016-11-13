package chapter5;

import java.util.ArrayList;
import java.util.List;

public class ListSynchronization extends Thread {

	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		list.add(10);list.add(20);list.add(30);list.add(40);
		ListSynchronization object = new ListSynchronization();
		Thread t1 = new Thread(object);t1.setName("Thread-1");
		Thread t2 = new Thread(object);t2.setName("Thread-2");
		t1.start();
		t2.start();
		
	}
	public void run() {
		System.out.println("run called");
		if (Thread.currentThread().getName().equals("Thread-1")) {
			list.add(88);
		}
		for (Integer val : list) {
			System.out.println(Thread.currentThread().getName()+"::"+val);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
