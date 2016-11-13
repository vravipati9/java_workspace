public class WaitTest extends Thread {
	public static void main(String[] args) {
		
		WaitTest obj = new WaitTest();
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		t1.start();t2.start();
	}
	public void run() {
		Logger l = new Logger();
		l.log("This is from First Thread");
		System.out.println(l.getContents());
	}
}
	

class Logger extends Thread {
	private StringBuilder contents = new StringBuilder();
	public void log(String message) {
		contents.append(System.currentTimeMillis());
		contents.append(": ");
		contents.append(Thread.currentThread().getName());
		contents.append(message);
		contents.append("\n");
	}

	public String getContents() {
		return contents.toString();
	}
}