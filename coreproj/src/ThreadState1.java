public class ThreadState1 extends Thread {
	public static void main(String[] args) {
		ThreadState1 t1 = new ThreadState1();
		t1.start();
		ThreadState1 t2 = new ThreadState1();
		t2.start();

	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.print(i + "	");
			if (i == 5)
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		System.out.print("\n");
	}
}
