package threads;

public class Synchronize {

	private int count = 0;
	
	public synchronized void increment() {
		count = count + 1;
	}
	public static void main(String[] args) {
		Synchronize mainThread = new Synchronize();
		mainThread.doWork();
	}
	public void doWork() {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join(); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(count);
	}
}
