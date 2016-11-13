public class ReturnTypeEx1 {

	public static void main(String[] args) {
		ReturnTypeEx1 obj = new ReturnTypeEx1();
		byte a = 3; // No problem, 3 fits in a byte
		byte b = 8; // No problem, 8 fits in a byte
		byte c = (byte) (b + a); // Should be no problem, sum of the two bytes
		long l = 130L;
		byte bi = (byte)l;
		System.out.println("The byte is " + bi); 
		float f = 234.56F;
		short s = (short)f;
		System.out.println("The short is " + s);
		System.out.println(obj.mOne());
		
		byte b1 = 3;
		b =  (byte) (b1 + 7);
	}
	public int mOne() {
		short s = 12;
		return s;
	}

}
