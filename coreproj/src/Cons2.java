class AOne11 {
	public AOne11(int a) {
		System.out.println("Aone1 default constructor");
	}
	public AOne11() {
		
	}
	
	void mOne() {
		System.out.println("mOne in AOne11");
	}
}

class ATwo2 extends AOne11 {
	public ATwo2() {
		
		System.out.println("ATwo2 default constructor");
	}
	
	void mTwo() {
		System.out.println("mTwo in ATwo");
	}
	
	void mOne() {
		System.out.println("mTwo in ATwo2");
	}
}

public class Cons2 {

	public static void main(String[] args) {
		//AOne11 aOne = new AOne11();
		//ATwo2 aTwo = new ATwo2();
		
		//AOne11 aOne1 = new ATwo2();
		//aOne1.mOne();
		
		ATwo2 a2 = (ATwo2)new AOne11();
		
		a2.mOne();
		
	}
}
