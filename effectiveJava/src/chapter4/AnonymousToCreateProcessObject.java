package chapter4;

public class AnonymousToCreateProcessObject {

	public static void main(String[] args) {
		insertRecords(new Runnable() {
			int i = 0;
			@Override
			public void run() {
				while(i<10) {
					i++;
					System.out.println("Count::::"+i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (i==10) {
						Thread.currentThread().interrupt();
						System.out.println("Thread has been stoped");
					}
				}
			}

		});
	}

	public static void insertRecords(Runnable thread) {
		System.out.println("::Insert Records called::");
		thread.run();
	}

}