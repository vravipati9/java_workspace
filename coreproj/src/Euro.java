import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.io.*;


class Money {
	public String country = "Canada";

	public String getC() {
		return country;
	}
}

class Yen extends Money {
	public String getC() {
		return super.country;
	}
}

public class Euro extends Money {
	public String getC(int x) {
		return super.getC();
	}
	//static Integer i;
	public static void main(String[] args) {
		System.out.print(new Yen().getC() + " " + new Euro().getC());
		
		Date d = new Date(0L);

		String ds = "December 15, 2004";
		DateFormat df = DateFormat.getDateInstance();
		try {
			d = df.parse(ds);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(d);
		
		double input = 314159.26;
		NumberFormat nf = NumberFormat.getInstance(Locale.ITALIAN);
		String b = nf.format(input);
		
		System.out.println(b);
		System.out.println("-------REGEX---------");
		double dob = 12.345;	// | 12.345|?
		// insert code here
		//System.out.println("|%7.3f|\n"	+dob);
		System.out.printf("|%1.3f| \n", dob);

	}

}