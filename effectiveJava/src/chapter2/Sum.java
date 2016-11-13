package chapter2;

public class Sum {
	public static void main(String[] args) {
		long sum = 0L;
		long startTime = System.currentTimeMillis();
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum = sum + i;
		}
		long totaltime = System.currentTimeMillis() - startTime;
		System.out.println(sum);
		System.out.println(totaltime);
	}
}
