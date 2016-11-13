public class Excep3 {
	public static void main(String a[]) {
		try {
			mOne();	
		} catch (InputValidation iv) {
			iv.printStackTrace();
		}
	}
	
	static void mOne() {
		try {
			Integer.parseInt("12adfasdf");	
		} catch (Exception e) {
			System.out.println("Excep");
			throw new InputValidation("Input Parameter is not a Number");
		}
	}
}

class InputValidation extends RuntimeException {
	public InputValidation(String s) {
		super(s);
		
	}
}