class SupInherit2 {
	final static String s = "Siva";
static String mOne() {
		return s;
	}
}

public class Inheri2 extends SupInherit2 {

	public static void main(String[] args) {
		System.out.println("asfdasdf");
		String s = mOne();
		System.out.println(s);
	}
}
