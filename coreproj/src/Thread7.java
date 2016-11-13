public class Thread7 {

	public static void main(String[] args) throws InterruptedException {
		Object o = new Object();
		synchronized (Thread.currentThread()) {
			o.wait();
			o.notify();
		}

	}

}
