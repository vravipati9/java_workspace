public class CardBoard {
	Short s = 200;
	public CardBoard go(CardBoard obj){
		obj = null;
		return null;
	}
	public static void main(String[] args) {
		CardBoard c1 = new CardBoard();
		CardBoard c2 = new CardBoard();
		CardBoard c3 = c1.go(c2);
		c1 = null;
		System.out.println(c2.s);
		System.out.println(c3.s);
	}

}
