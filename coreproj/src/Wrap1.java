
public class Wrap1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer y = 567; // make a wrapper
		Integer x = y;
		//System.out.println("y==x  " + (y == x));
		y++; // unwrap, use, "rewrap"
		//System.out.println(x + " " + y); // print values
		//System.out.println(y == x);
		
		Integer i1 = 1000;
		int i2 = 1000;
		
		if(i1 == i2) System.out.println("same objects");
		if(i1.equals(i2)) System.out.println("meaningfully equal");
		

	}

}
