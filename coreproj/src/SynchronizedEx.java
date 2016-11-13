public class SynchronizedEx extends Thread {

	public static void main(String[] args) {
		SynchronizedEx obj = new SynchronizedEx();
		SynchronizedEx obj1 = new SynchronizedEx();
		Thread t1 = new Thread(obj);t1.setName("TOne");
		Thread t12 = new Thread(obj1);t1.setName("TOneTwo");
		Thread t2 = new Thread(obj);t2.setName("TTwo");
		Thread t3 = new Thread(obj);t3.setName("TThree");
		t1.start();t2.start();t3.start();t12.start();
		
	}
	public void run() {
		SynchronizedEx.classMethod();
		//SynchronizedEx.mOne();
	}
	public static void classMethod() {
		synchronized (SynchronizedEx.class) {
			for (int i = 0; i < 20; i++) {
				System.out.println(""+Thread.currentThread().getName());
			}
		}
	}
	public static void mOne() {
		for (int i = 0; i < 20; i++) {
			System.out.println(i+"	"+Thread.currentThread().getName());
		}
	}
}
