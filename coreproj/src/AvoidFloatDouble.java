import static java.lang.System.out;

import java.math.BigDecimal;

public class AvoidFloatDouble {

	public static void main(String[] args) {

		/*
		 * double funds = 1.00; int itemsBought = 0; for (double price = .10;
		 * funds>=price; price+=.10 ) { funds = funds-price; itemsBought++; }
		 * out.println("Items Bought>>>"+itemsBought);
		 * out.println("funds>>>"+funds);
		 */
		BigDecimal funds = new BigDecimal("1.00");
		int itemsBought = 0;
		final BigDecimal TEN_PAISA = new BigDecimal(".10");
		BigDecimal price = new BigDecimal(".10");
		for (BigDecimal bg = TEN_PAISA; funds.compareTo(price)>=0; price = price.add(TEN_PAISA)) {
			funds = funds.subtract(price);
			itemsBought++;
		}
		out.println("Items Bought>>>"+itemsBought);
		out.println("funds>>>"+funds);

	}
}
