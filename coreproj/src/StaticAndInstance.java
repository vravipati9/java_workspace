public class StaticAndInstance {
	public static void main(String a[]) {
		AnotherCls obj = new AnotherCls();
		obj.go();
		//go();
	}
	 static void go() {
		System.out.println("Go Method in AnotherCls");
	}
	
}

class AnotherCls {
	void go() {
		System.out.println("Go Method in AnotherCls");
	}
}
