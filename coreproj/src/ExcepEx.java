public class ExcepEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			int res= mOne();	
		} catch (Exception e) {
			System.out.println("Generated Exception..."+e);
		}
		catch (Throwable e) {
			System.out.println("Generated Exception..."+e);
		}

	}
	static int mOne() throws Exception {
		int res=0;
		String[] str = new String[2];
		try {
			int i=5; int j=0;
			//res = i/j;
			System.out.println(str[5]);	

		} catch (ArithmeticException e) {
			//e.printStackTrace();
			System.out.println("**RSRK**"+e);
			throw new Exception("divide by Zero Error");
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			//e.printStackTrace();
			System.out.println("**RVVS**"+e);
			throw new Exception("Array Index out Of bounds Exception");
		}
		return res;
	}

}
