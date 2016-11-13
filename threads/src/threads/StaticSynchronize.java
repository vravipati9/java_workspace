package threads;


public class StaticSynchronize extends Thread {
    static synchronized void f() {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("*******f**********");
    }
    synchronized void g() {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("******g**********");
    }
    public static void main(String a[]) {
    	long i = System.currentTimeMillis();
    	StaticSynchronize.f();
    	StaticSynchronize t1 = new StaticSynchronize();
    	t1.start();
    	try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	long j = System.currentTimeMillis();
    	System.out.println(j - i);
	}
    
    @Override
    public void run() {
    	StaticSynchronize t2 = new StaticSynchronize();
    	t2.g();
    }
}