public class Staticblock {
	public static void main(String a[]) throws ClassNotFoundException {
		StaticInitializer obj = new StaticInitializer();
		int i =4;
		mOne(i);
	}
	static void mOne(long l) {
		System.out.println("long");
	}
	static void mOne(float l) {
		System.out.println("float");
	}
	static void mOne(Number l) {
		System.out.println("Number");
	}
	static void mOne(Float l) {
		System.out.println("Float");
	}

}

class StaticSupCls {
	public StaticSupCls() {
		System.out.println("Sup Conss");
	}
	
	
}
class StaticInitializer extends StaticSupCls {
	public static final int A = 5;
	public static final int B; 
	{
		System.out.println("In init() block");
	}								
	static {
		System.out.println("In static block");
		if (A == 5)
			B = 10;
		else
			B = 5;
	}
	


	public StaticInitializer() throws ClassNotFoundException {
		System.out.println("A	:"+A+"	B"+B);
		Dog2 d = new Dog2();
	} 
}