public class AssignmentOps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sizeOfYard = 10;
		int numOfPets = 3;
		String msg = (sizeOfYard > 15)?"size of yard is OK":(numOfPets<5)?"Pets size is greater":"Pets size is ok";
		System.out.println(msg);
		
		doStuff();
		System.out.println("after method call");
	}
	static boolean doStuff() {
		for (int x = 0; x < 3; x++) {
		System.out.println("in for loop");
		//return true;
		//break;
		System.exit(1);
		}
		System.out.println("end for loop");
		return true;
	}
}
