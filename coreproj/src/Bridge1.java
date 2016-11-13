public class Bridge1 {
	public enum Suits {
		CLUBS(20), DIAMONDS(20), HEARTS(30), SPADES(30), NOTRUMP(40) {
			public int getValue(int bid) {
				return ((bid - 1) * 30) + 40;
			}
		};
		Suits(int points) {
			this.points = points;
		}

		private int points;

		public int getValue(int bid) {
			return points;
		}
	}

	public static void main(String[] args) {
		//System.out.println(Suits.NOTRUMP.getBidValue(3));
		System.out.println(Suits.CLUBS.points);
		System.out.println(Suits.values());
	}
}