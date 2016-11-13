public class StringBufferThread extends Thread {
	StringBuffer sb = null;

	public static void main(String[] args) {
		System.out.println("EXECUTE");
		StringBufferThread thread1 = new StringBufferThread(new StringBuffer("A"));
		StringBufferThread thread2 = new StringBufferThread(new StringBuffer("B"));			
		StringBufferThread thread3 = new StringBufferThread(new StringBuffer("C"));
		thread1.start();
		thread2.start();
		thread3.start();
	}

	public StringBufferThread(StringBuffer sb) {
		this.sb = sb;
	}

	public void run() {
		displayRes(sb);
	}
	private void displayRes(StringBuffer sb) {
		StringBuffer sbf = new StringBuffer(sb);
		for (int i = 0; i < 100; i++) {
			System.out.println(sbf);
			sbf = sbf.append(sb);
		}
	}
}
