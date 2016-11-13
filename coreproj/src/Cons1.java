import java.io.IOException;
class RunTmEx extends RuntimeException {
	public RunTmEx(String s) {
		
	}
}


class Cons {
	public Cons() throws RunTmEx {
		System.out.println("Super Cons.."+s);
		s = " Static variable reassigned";
		throw new RunTmEx("Constructor not Initialized properly");
	}
	public static String s  = "Iam in Super class";
	
	protected void mOne() {
		
	}
}
public class Cons1 extends Cons {
	public static void main(String a[]) {
		Cons c = new Cons1();
		c.mOne();
	}
	public void mOne() {
		System.out.println(Cons.s);
	}
	public Cons1() {
		System.out.println("Child Cons..."+s);
	}
}
