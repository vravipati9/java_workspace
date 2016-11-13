interface MOne {
	static class a {
		void mOne() {
			System.out.println("asdad");
		}
	}
}

class TOne extends Thread {
	public void run() {
		System.out.println("Run method called..");
		if (Double.NaN < Double.NaN) {
			System.out.println("Both are equal::"+Double.NaN);
		} else {
			System.out.println("Both are not equal::"+Double.NaN);
		}
		
	}
}


public class Thread6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TOne t = new TOne();
		t.start();
		//t.start();
	}

}
