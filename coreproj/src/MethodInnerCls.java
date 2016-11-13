public class MethodInnerCls {

	public static void main(String[] args) {
		

	}
	static public void go() {
		class MethodLocalCls {
			public void localGo() {
				System.out.println("Local Go");
			}
		};
		MethodLocalCls innerCls = new MethodLocalCls();
		System.out.println("Method End");
	}

}
