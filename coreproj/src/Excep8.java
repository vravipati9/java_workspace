public class Excep8 {
	public static void main(String[] args) {
		
		System.out.println(mOne());
	}
	
	static String mOne() {
		try {
			return "try";	
		} catch (Exception e) {
			return "catch";
		} finally {
			return "finally";
		}
	}
}
