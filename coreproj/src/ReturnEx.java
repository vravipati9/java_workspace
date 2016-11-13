public class ReturnEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "siva rama";
		String[] ar = s.split(" ");
		System.out.println(ar[0]);
		System.out.println(ar[1]);
		String str = mOne();
		System.out.println(str);

	}
	static String mOne() {
		int x = 1;
        switch(x) {
          case 1:  {
            System.out.println("x is one");  break;
          }
          case 2:  {
            System.out.println("x is two");  break;
          }
          case 3:  {
            System.out.println("x is two");  break;
          }
        }
        return "success";
	}

}
