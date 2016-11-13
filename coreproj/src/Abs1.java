/*
 * Static method can not override.
 */
class AbsOne {
	static void mOne() {
		System.out.println("Method called");
	}
	
	static void mOne(String s) {
		System.out.println("Method called");
	}
	
	final void mFour() {
		System.out.println("Method called");
	}
	
	final void mFour(String s) {
		System.out.println("Method called");
	}



	String mThr() {
		return null;
	}
	void mThr(String s) throws Exception {
		
	}
}


class AbsTwo extends AbsOne {
	static void mTwo() {
		System.out.println("Method called");
	}
	
	

}


public class Abs1 {
	public static void main(String a[]) {
		AbsOne obj = new AbsOne();
		AbsOne obj2 = new AbsTwo();
		obj2.mOne();
		Object b = (AbsTwo)obj2;
		System.out.println("Name>>>>"+b.getClass().getName());
		obj.mOne();
		int i = 129;
		int j = 129;
		Integer k = 127;
		Integer l = 127;
		System.out.println("i == j   "+(i==j));
		System.out.println("k == l   "+(k==l));
		AbsOne obj1 = new AbsTwo();
		((AbsTwo)obj1).mTwo();
	}
	 
}
