public class InnerCls1 {
	public static void main(String a[]) {
		MyOuter mo = new MyOuter();
		//mo.makeInner(); // one way
		//mo.makeInner();
		MyOuter.MyInner mi =  mo.new MyInner();
		mi.seeOuter();
	}
}

class MyOuter {
	private int x = 7;
	public int z = 9;
	public void makeInner() {
		MyInner in = new MyInner(); // make an inner instance
		in.seeOuter();
	}

	class MyInner {
		public int y = 8;
		public void seeOuter() {
			
			System.out.println("Outer x is " + x);
			System.out.println("Inner class ref is " + this);
			System.out.println("Outer class ref is " + MyOuter.this);
		}
	}
}