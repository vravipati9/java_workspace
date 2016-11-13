class Inn {
	private int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}
class Out {
	private Inn i;

	public Inn getI() {
		return i;
	}

	public void setI(Inn i) {
		this.i = i;
	}
}
public class Test3 {
	public static void main(String[] args) {
		Out o = new Out();
		Inn i = new Inn();
		int n = 10;
		i.setX(n);
		o.setI(i);
		//i.setX(100);
		//Inn i1 = new Inn(); i.setX(100); o.setI(i);
		o.getI().setX(100);
		
		System.out.println(o.getI().getX());
		
//		StringBuffer s = new StringBuffer("123456789");
//		System.out.println(s);
//		System.out.println(s.substring(0, 4));
//		s.delete(1, 4);
//		System.out.println("delete 1-4	" +s);
//		s.insert(1, 99);
//		System.out.println("Insert 99 at 1	" +s);
		
		StringBuffer s = new StringBuffer("123456789");
		System.out.println(s);
		s = s.delete(0,3); System.out.println("delete(0,3)"+s);
		s = s.replace(1,3,"24");System.out.println("replace(1,3,24)"+s);
		s = s.delete(4,6);System.out.println("delete(4,6)"+s);
		//s.delete(0,3).replace(1,3,"24").delete(4,6);
		System.out.println(s);

	}

}
