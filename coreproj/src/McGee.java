public class McGee {
	public static void main(String[] args) {
		Days d1 = Days.TH;
		Days d2 = Days.M;
		for (Days d : Days.values()) {
			if (d.equals(Days.F))
				break;
			d2 = d;
		}
		System.out.println(d2);
		System.out.println((d1 == d2) ? "same old" : "newly new");

	}
	enum Days {
		M, T, W, TH, F, SA, SU
	};
}

class Nav {
	public enum Direction {NORTH, EAST, SOUTH, WEST};
}
class Sprite {
	Nav.Direction obj = Nav.Direction.EAST;
}