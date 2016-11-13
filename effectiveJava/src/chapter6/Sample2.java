package chapter6;

import java.util.ArrayList;
import java.util.List;

//Program containing marker annotations
public class Sample2 {
	@Test
	public static void m1() {
	} // Test should pass

	@ExceptionTest(value = ArithmeticException.class)
	public static void m2() {
		int i = 2/0;
	}

	@ExceptionTest(value = ArithmeticException.class)
	public static void m4() { // Should fail (wrong exception)
		int[] a = new int[0];
		int i = a[1];
	}
	
	@ExceptionTest(ArithmeticException.class)
	public static void m3() { } // Should fail (no exception)

	@ExceptionTest({ IndexOutOfBoundsException.class, NullPointerException.class })
	public static void doublyBad() {
		List<String> list = new ArrayList<String>();
		// The spec permits this method to throw either
		// IndexOutOfBoundsException or NullPointerException
		list.addAll(5, null);
	}
}
