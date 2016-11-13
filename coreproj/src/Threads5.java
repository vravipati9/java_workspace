public class Threads5 {

	public static void main(String[] args) {
		 new Threads5().go();
	}
	public void go() {
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("Foo");
			}
		};
		Thread t = new Thread(r);
		t.start();
		//t.start();
	}

}
