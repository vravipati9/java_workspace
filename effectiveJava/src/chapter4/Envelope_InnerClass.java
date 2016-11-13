package chapter4;
//Item 22
/*
 * Each instance of a nonstatic member class is implicitly associated with an enclosing instance of its containing class. 
 * Within instance methods of a nonstatic member class, you can invoke methods on the enclosing instance or obtain a reference
 * to the enclosing instance using the qualified this construct"
 */
public class Envelope_InnerClass {
	private static int i;
	private int j;
	void x() {
		System.out.println("Hello");
	}

	class Enclosure {
		void x() {
			System.out.println(i);
			Envelope_InnerClass.this.x(); /* Qualified*/
		}
	}
	
	static class Enclosure1 {
		void x() {
			System.out.println(i);
			//Envelope_InnerClass.this.x(); /* Qualified*/
		}
	}
	
	public static void main(String[] a) {
		Envelope_InnerClass.Enclosure obj = new Envelope_InnerClass().new Enclosure();
		obj.x();
	}
	
	
} 