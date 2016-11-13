
public class Excep7 {
	public static void main(String[] args) {
		try {
			test();
		} catch (AssertionError ex) {
			System.out.print("exception ");
		}
		System.out.print("end ");
	}

	static void test() throws AssertionError {
		if (true)
			throw new AssertionError();
		System.out.print("test ");
	}
}




