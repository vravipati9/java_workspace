class NameRunnable implements Runnable {
	public void run() {
		for (int x = 1; x <= 3; x++) {
			System.out.println("Run by " + Thread.currentThread().getName()
					+ ", x is " + x);
		}
	}
}

public class SimpleThread implements Runnable {

	public static void main(String[] args) {
		NameRunnable obj = new NameRunnable();
		Thread t1 = new Thread(obj);t1.setName("ThreadOne");
		Thread t2 = new Thread(obj);t2.setName("ThreadTwo");
		Thread t3 = new Thread(obj);t3.setName("ThreadThree");
		t1.start();t2.start();t3.start();
	}

	public void run() {
		System.out.println("Run called");
	}
}
