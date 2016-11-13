
public class StaticEx {

	/**
	 * @param args
	 */
	public static int x = 7;
	public int y = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticEx a = new StaticEx(); 
		StaticEx b = new StaticEx(); 
		a.y = 5; 
		b.y = 6; 
		a.x = 1; 
		b.x = 2; 
		System.out.println("a.y = " + a.y); //5
		System.out.println("b.y = " + b.y); //6
		System.out.println("a.x = " + a.x); // 2
		System.out.println("b.x = " + b.x); //2
		System.out.println("IdentifyMyParts.x = " + StaticEx.x);  //2

	}



}
