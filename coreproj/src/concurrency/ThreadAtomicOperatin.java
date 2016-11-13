package concurrency;
import java.util.HashMap;
import java.util.Map;

public class ThreadAtomicOperatin {
	public static void main(String a[]) {
		Counter1 counter = new Counter1(); // create an instance of the Counter
		  CountingTask task = new CountingTask(counter); // pass the counter to the runnable CountingTask
		 
		   
		  //Create 10 user threads (non-daemon) from the main thread that share the counter object  
		  Thread thread1 = new Thread(task, "User-1");
		  Thread thread2 = new Thread(task, "User-2");
		  Thread thread3 = new Thread(task, "User-3");
		   
		   
		  //start the threads
		  thread1.start();
		  thread2.start();
		  thread3.start();
	}
}

class Counter1 {
	 //shared variable or resource
	 private Integer count = Integer.valueOf(0); 
	  
	 private Map<String, Integer> userToNumber = new HashMap<String, Integer>(10);
	 
	 public void  increment() {
	  //try {
	   count = count + 1;   //increment the counter
	   //Thread.sleep(50);    // to imitate other operations and to make the racing condion to occur more often for the demo
	   Thread thread = Thread.currentThread();
	   userToNumber.put(thread.getName(), count);
	  //} catch (InterruptedException e) {
	   //e.printStackTrace();
	 // }
	 
	 }
	  
	  
	 public Integer getCount(String name) {
	  return userToNumber.get(name);
	 }
}

class CountingTask implements Runnable { 
	 
	 private Counter1 counter;
	 
	 public CountingTask(Counter1 counter) {
	  super();
	  this.counter = counter;
	 }
	 
	 @Override
	 public void run() {
	  counter.increment();
	  Thread thread = Thread.currentThread();
	  System.out.println(thread.getName() + " value is " + counter.getCount(thread.getName()));
	   
	 }
}
