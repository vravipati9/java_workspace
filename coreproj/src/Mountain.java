class Atom {
	Atom() {
		System.out.print("atom ");
	}
}

class Rock extends Atom {
	Rock(String type) {
		//
		System.out.print(type);
	}
	
}

public class Mountain extends Rock {
	Mountain() {
		super("granite ");
		new Rock("granite ");
	}

	public static void main(String[] a) {
		new Mountain();
	}
}

//atom, default rock, atom, granite atom granite
//atom granite defaulrrock, atom granite dafaultrock