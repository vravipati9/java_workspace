public class Super_Cls {
	public void mOne() {
		System.out.println("mOne called from Super_Cls");
		mTwo();
	}
	public void mTwo() {
		System.out.println("mTwo called from Super_Cls");
	}
	protected void mThree() {
		System.out.println("mThree called from Super_Cls");
	}	
}
