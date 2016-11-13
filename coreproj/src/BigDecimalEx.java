import java.math.BigDecimal;
import java.math.RoundingMode;


public class BigDecimalEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * If the region/range values have different decimal places, the system uses the highest number of decimal places and assumes 0 for the other value. 
			For example, if the high price is 2.1234 and the low price is 2.11 then the system assumes the low price is 2.1100 and the average is 2.1234 + 2.1100/2 = 4.2334/2 = 2.1167 

			If the final calculation is greater than four decimal places, then the system rounds down to four decimal places. If the value is 5 or greater then round up and if less then four then round down. 
			For example, if the calculated value is 1.12345 then the value is 1.1235. If the calculated value is 1.12344 then the value is 1.1234.
		 */
		System.out.println(010|4);
		BigDecimal b1 = new BigDecimal(2.2222);
		BigDecimal b2 = new BigDecimal(10.2343);

		//	6.228249999999999619859636368346400558948516845703125
		float f1 = 2.2222f;
		float f2 =  10.2343f;
		float f3 = f1 + f2;
		float f4 = f3/2;
		System.out.println("float.."+f4);
		BigDecimal bd1 = new BigDecimal(f4);
		System.out.println(bd1.setScale(4, RoundingMode.HALF_UP));

		BigDecimal b3 = b1.add(b2);
		BigDecimal b3_1 = b3.divide(new BigDecimal(2));
		System.out.println("bg..."+b3_1);
		System.out.println("bgfloat..."+b3_1.floatValue());
		BigDecimal b3_4 = new BigDecimal(b3_1.floatValue());
		System.out.println("bgfloatBigD..."+b3_4);
		System.out.println("bgfloat.1.."+b3_4.setScale(4, RoundingMode.HALF_UP));


		System.out.println(b3_1.setScale(4, RoundingMode.HALF_UP));

		float b3_2 = b3.floatValue()/2; //,4, RoundingMode.HALF_UP);
		System.out.println("asda"+b3_2);
		BigDecimal b3_3 = new BigDecimal(b3_2);
		System.out.println("asda"+b3_3);
		System.out.println("value with out format..."+b3_3.setScale(4, RoundingMode.HALF_UP));



		

		System.out.println("-----------------");
		//BigDecimal b9 = b2.
		//System.out.println(b9.ROUND_CEILING);
		//System.out.println(b9.ROUND_DOWN);
		BigDecimal bg1 = new BigDecimal(2.11);
		if (bg1.scale() < 4) {
			bg1 = bg1.setScale(4,RoundingMode.HALF_UP);
		} 
		BigDecimal bg3 = new BigDecimal(2.12344);
		//System.out.println(bg2);
		//BigDecimal bg3 = bg1.add(bg2).divide(new BigDecimal(2),4,RoundingMode.HALF_UP);
		System.out.println("......"+bg3);
		System.out.println("halfup......"+bg3.setScale(4, 0));
		System.out.println("ceiling......"+bg3.setScale(4, RoundingMode.HALF_UP));


		//BigDecimal bg = new BigDecimal().scale()
	}
}
