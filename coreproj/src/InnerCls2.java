public class InnerCls2 {
	private String str = "abc";
	public void doStuff() {
		final String str1 = "def";
		class MyInner2 {
			void innerMethod() {
				System.out.println("InnerMethod  :"+str);
				System.out.println("InnerMethod  :"+str1);
			}
		}
		System.out.println("InnerMethod11");
		MyInner2 innerObj = new MyInner2();
		innerObj.innerMethod();
	}

	public static void main(String[] args) {
		InnerCls2 obj = new InnerCls2();
		obj.doStuff();

	}

}
