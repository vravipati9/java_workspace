// yield method is not guaranteed

public class ThreadState2 extends Thread {
	public static void main(String[] args) throws InterruptedException {
		ThreadState2 obj = new ThreadState2();
		Thread t1 = new Thread(obj, "TOne");
		Thread t2 = new Thread(obj, "TTwo");
		Thread t3 = new Thread(obj, "TThree"); 
		t1.start(); 
		
		t2.start();
		t3.start();
		t3.join();
		if (t1.getState().toString() == "TERMINATED") {
			t1.start();
		} 
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread "+ Thread.currentThread().getName()+""+ Thread.currentThread().getState());
			if (i==3 && Thread.currentThread().getName().equals("TThree")) {
				Thread.yield();
			}
		}
		System.out.print("\n");
	}
}
