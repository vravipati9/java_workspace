package chapter2;

public class PreferPrimitive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void sum(String[] args) {
		Long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	
	public static void sumWithBoxing(String[] args) {
		Long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum = sum.longValue()+i;
		}
		System.out.println(sum);
	}
}
