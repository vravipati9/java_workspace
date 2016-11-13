class SubException extends Exception {
}

class SubSubException extends SubException {
}

public class CC {
	void doStuff() throws SubException {
	}
	public static void main(String a[]) {
		CC c = new CC3();
		try {
			c.doStuff();
		} catch (SubException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println("Ended Program.........");
	}
}

class CC2 extends CC {
	void doStuff() throws SubSubException {
		System.out.println("CC2");
	}
}

class CC3 extends CC {
	//void doStuff() throws Exception {
	//}
	void doStuff() throws NumberFormatException {
		System.out.println("CC3");
		throw new NumberFormatException();
	}
}

class CC4 extends CC {
	void doStuff(int x) throws Exception {
		System.out.println("CC4");
	}
}

class CC5 extends CC {
	void doStuff() {
		System.out.println("CC5");
	}
}
class CC6 extends CC {
	void doStuff() throws SubException {
		System.out.println("CC5");
	}
}