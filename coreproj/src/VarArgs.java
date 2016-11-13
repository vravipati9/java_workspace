public class VarArgs {
	public static void main(String[] args) {
		new VarArgs().go(4, "siva");

	}
//VarArgs param must be the last parameter
//	void go(String... args, int i) {
//		System.out.println(args[args.length-1]);
//	}
	
	void go(int i, String...args) {
	System.out.println(args[args.length-1]);
}
}

class Super {
	private int a;

	protected Super(int a) {
		this.a = a;
	}
}

class Sub extends Super {
	public Sub(int a) {
		super(a);
	}

	public Sub() {
		//this(5);
		super(5);
	}
}
