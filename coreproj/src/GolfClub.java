// Not OK; GolfClub does not implement Sporty I don't care what anyone says
// variable of type byte, short, or char can be explicitly promoted and assigned to an int
// an array of any of those types could be assigned to an int array. You can't do that in Java

// we can'nt assign one array type to another array type. But we can assign any value that can be 
		//prompted implicity to the declared type.

interface Sporty {
	void beSporty();
}

class Ferrari implements Sporty {
	public void beSporty() {

	}
}

class RacingFlats implements Sporty {
	public void beSporty() {

	}
}

public class GolfClub {
	public static void main(String[] args) {
		Sporty[] sportyThings = new Sporty [3];
		sportyThings[0] = new Ferrari(); 
		sportyThings[1] = new RacingFlats();
		//sportyThings[1] = new GolfClub();
		
		int[] intarr ;
		int[] intarr1 = new int[3];
		char[] chararr = new char[3];
		intarr = intarr1;
		//intarr = chararr;	// we can'nt assign one array type to another array type. But we can assign any value that can be 
		//prompted implicity to the declared type.
		Object[] obj = new String[3];
		obj[0] = "ONE";
		obj[1] = new Object();	// ArrayStoreException
		
	}

}
