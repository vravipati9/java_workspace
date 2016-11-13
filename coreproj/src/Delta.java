interface Fool {
}

class Alpha implements Fool {
}

class Beta extends Alpha {
}

class Delta extends Beta {
	public static void main(String[] args) {
		System.out.println("Done");
		Beta x = new Beta();
		Alpha a = x;
		//Fool f = (Delta)x;
		Fool f = (Alpha)x;
		Beta b = (Beta)(Alpha)x;
		System.out.println("Calling Go.....");
		go();
	}

	static void go() {
		String o = "";
		z: for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 2; y++) {
				if (x == 1)
					break;
				if (x == 2 && y == 1)
					break z;
				o = o + x + y;
				System.out.println(o);
			}
		}
		System.out.println(o);

	}
}