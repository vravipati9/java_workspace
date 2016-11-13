public class CastingEx {

	public static void main(String[] args) {
		byte s = 123;
		int i = 209;
		s = (byte) i; // explicit casting
		System.out.println("    " + s);
		boolean b = false;
		
		if (b = true) {
			System.out.println("b is true");
		} else {
			System.out.println("b is false");
		}
		int x = 1;
		//if (x = 0)	{}
	}

}
