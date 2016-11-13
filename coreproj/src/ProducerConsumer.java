import java.util.concurrent.TimeUnit;
public class ProducerConsumer {
	private int count;
	
	public synchronized void consume() {
		while(count == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
			count--;
			System.out.println("Consumed:"+count);
	}
	
	public synchronized void produce() {
		count++;
		System.out.println("Produced:"+count);
		notify();
	}
	
	public static void main(String a[])  throws InterruptedException {
		final ProducerConsumer pc = new ProducerConsumer();
		int i = 0;
		
		Runnable producerThread = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(":::Producer thread started Execution:::");
				while(true) {
					pc.produce();
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
			}
		};
		
		Runnable consumerThread = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(":::Consumer thread started Execution:::");
				while(true) {
					pc.consume();
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
			}
		};
		  new Thread(producerThread).start();
		  TimeUnit.SECONDS.sleep(2);
		  new Thread(consumerThread).start();
	}
	

}
