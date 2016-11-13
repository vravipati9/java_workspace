class TestException extends Exception {
	
}
class AOne1 {
	public void mOne() {
		BOne1 bOne = new BOne1();
		//try {
			//bOne.mTwo();
		//} catch (TestException e) {

		//	e.printStackTrace();
		//}  
	}
}
class BOne1 {
	public void mTwo() {
		try {
			String s = null;
			s.toString();
		} finally {
			System.out.println("finally");
		}
	}
	static class AC {
		void process() throws Exception { throw new Exception(); }
		
	}
	static class BC extends AC {
		void process() { System.out.println("B"); }
	}
}

public class Excep6 {
	static int[] intArr = new int[2];
	static {
		intArr[7] = 12;
	}
	public static void main(String[] args) {
		BOne1 b = new BOne1();
		BOne1.BC obj = new BOne1.BC();
		obj.process();
		try {
			b.mTwo();
		} catch (Exception e) {
			System.out.println("Excepition");
		}
		System.out.println("End");
	}
}
