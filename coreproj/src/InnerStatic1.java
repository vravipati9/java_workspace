class InnerStatic {
	static class Nest {
		void go() {
			System.out.println("hi");
		}
	}
}

public class InnerStatic1 {
	static String str;
	static class B2 {
		String str1;
		void goB2() {
			System.out.println("hi 2"+str+str1);
		}
	}
	class B3 {
		void goB2() {
			System.out.println("B3");
		}	
	}

	public static void main(String[] args) {
		InnerStatic.Nest n = new InnerStatic.Nest(); // both class names
		n.go();
		B2 b2 = new B2(); // access the enclosed class
		b2.goB2();
		InnerStatic1 obj = new InnerStatic1();
		B3 b3  = obj.new B3();
		b3.goB2();
	}
}