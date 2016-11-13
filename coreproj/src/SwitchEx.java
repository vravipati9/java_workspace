// Make sure a char variable is declared before the switch statement.
// Each case statement should be followed by a break.
// The default case can be located at the end, middle, or top.
public class SwitchEx {

	public static void main(String[] args) {
		char c = 5;
		switch (c) {
		case 4:
			if (true) {
				System.out.println("true");
				int i =2;
				switch (i) {
				case 1:
					System.out.println("1");
					break;
				default:
					break;
				}
			}
			else {
				System.out.println("false");
			}
			break;
		case 5:
			System.out.println("5");
			break;

		default:
			System.out.println("default");
		}
		int x = 2;
		int y = 2;
		while(x == 2) {
		x++; ++y;
		System.out.println("x	:"+x+"	y	:"+y);
		}		
		boolean b;
		//while (b = true) { } not possible in while loop
		if (b = true) {}
	}

}
