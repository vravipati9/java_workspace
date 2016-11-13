import java.util.Date;

public class CheckGC {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		System.out.println("Total JVM memory: " + rt.totalMemory());
		System.out.println("Before Memory = " + rt.freeMemory());
		Date d = null;
		
		for (int i = 0; i < 1000; i++) {
			d = new Date();
			d = null;
		}
		System.out.println("After Memory = " + rt.freeMemory());
		rt.gc(); // an alternate to System.gc()
		System.out.println("After GC Memory = " + rt.freeMemory());
		int i = 12;
		byte b = 124;
		i = b;
		System.out.println(b);
		
	}
	@Override
	protected void finalize() throws Throwable {
		//super.finalize();
		System.out.println("finalize");
	}
}