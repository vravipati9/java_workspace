class TestOR {
	public static void main(String[] args) {
		if ((isItSmall(3)) || (isItSmall(7))) {
			System.out.println("Result is true");	//2
		}
		if ((isItSmall(6)) || (isItSmall(9))) {
			System.out.println("Result is true");	
		}
		System.out.println("xor " + ((2>3) ^ (4<3)));
	}

	public static boolean isItSmall(int i) {
		if (i < 5) {
			System.out.println("i < 5");	//1
			return true;
		} else {
			System.out.println("i >= 5");	//3	//4
			return false;
		}
	}
}