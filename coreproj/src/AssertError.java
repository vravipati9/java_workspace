public class AssertError {
	public static void main(String[] args) {
		try {
			test();
		} catch (Exception ex) {
			System.out.print("exception ");
		}
		System.out.print("end ");
	}
	static void test() throws Error {
		if (true)
			throw new AssertionError();
		System.out.print("test ");
	}
}
