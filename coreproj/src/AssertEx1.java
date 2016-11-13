public class AssertEx1 {

	public static void main(String[] args) {
		methodA(2);
	}
	static void methodA(int num) {
		assert(num<10);
		System.out.println("Assert pass");
	}

}
