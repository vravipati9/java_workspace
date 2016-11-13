public class BreakEx {

	public static void main(String[] args) {
		BreakEx.go();
	}
	static void go() {
		boolean boo = true;
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				System.out.println("ENTER");
				if (i==j) {
					System.out.println("i === j  "+i+"  "+j);
					break;
				}
				else {
					//System.out.println("i  != j  "+i+"  "+j);
				}
			}
			System.out.println("Out of Inner loop");
		}
		System.out.println("Out of Outer loop");
	}
}
