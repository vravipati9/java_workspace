package amplex;

class SimpleSingleTon {
	private SimpleSingleTon() {};
	private static SimpleSingleTon instance = new SimpleSingleTon();
	public SimpleSingleTon getInstance() {
		return instance;
	}
}

public class SingleTonCheck extends Thread {
	public static void main(String[] args) {
		System.out.println("*******Thread Code Execution********");
		Thread t1 = new Thread("One");
		Thread t2 = new Thread("Two");
		SingleTonCheck obj1 = new SingleTonCheck();
		t1.start();
		
	}

}
