class Excp1 {
	public static void mOne() throws Exception{
		String s1 = "10";
		String s2 = "0";
		int i = Integer.parseInt(s1);
		int j = Integer.parseInt(s2);
		try {
			int k = i/j;	
		} catch (Exception e) {
			System.out.println("In Arhematic Exception");
			throw e;
		}

		System.out.println("First Cond");
		try {
			String[] s = new String[3];
			System.out.println(s[7]);
		} catch (Exception e) {
			System.out.println("Array Index Out Of bounds");
			throw e;
		}
		if (true) {
			System.out.println("true");			
		}


	}
}

public class ExcepEx1 extends Excp1{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ExcepEx1 obj = new ExcepEx1();
		mOne();
		System.out.println("After Executing all Stmts");
	}
}
