import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Dates3 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2011, 9, 4); // October 4, 2011
		// (month is 0-based
		Date d2 = c.getTime();
		System.out.println("Date set by user  : "+d2);
		Locale locIT = new Locale("it", "IT"); // Italy
		Locale locPT = new Locale("pt"); // Portugal
		Locale locBR = new Locale("pt", "BR"); // Brazil
		Locale locIN = new Locale("hi", "IN"); // India
		Locale locJA = new Locale("ja"); // Japan
		Locale locCH = new Locale("it", "CH");  // Language is Italy and Country is Switzerland
		
		DateFormat dfUS = DateFormat.getInstance();
		System.out.println("US :" + dfUS.format(d2));
		
		DateFormat dfUSfull = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println("US full :" + dfUSfull.format(d2));
		
		DateFormat dfIT = DateFormat.getDateInstance(DateFormat.FULL, locIT);
		System.out.println("Italy :" + dfIT.format(d2));
		
		DateFormat dfPT = DateFormat.getDateInstance(DateFormat.FULL, locPT);
		System.out.println("Portugal :" + dfPT.format(d2));
		
		DateFormat dfBR = DateFormat.getDateInstance(DateFormat.FULL, locBR);
		System.out.println("Brazil :" + dfBR.format(d2));
		
		Locale locDK = new Locale("da", "DK"); // Denmark
		
		DateFormat dfIN = DateFormat.getDateInstance(DateFormat.FULL, locIN);
		System.out.println("India :" + dfIN.format(d2));
		
		DateFormat dfJA = DateFormat.getDateInstance(DateFormat.FULL, locJA);
		System.out.println("Japan :" + dfJA.format(d2));

		DateFormat dfCH = DateFormat.getDateInstance(DateFormat.FULL, locCH);
		DateFormat dfCHShort = DateFormat.getDateInstance(DateFormat.SHORT, locCH);
		System.out.println("Switzerland :" + dfCH.format(d2));
		System.out.println("Switzerland Short :" + dfCHShort.format(d2));
		
		System.out.println("def " + locBR.getDisplayCountry());
		System.out.println("loc " + locBR.getDisplayCountry(locBR));
		System.out.println("def " + locDK.getDisplayLanguage());
		System.out.println("loc " + locDK.getDisplayLanguage(locDK));
		System.out.println("D>I " + locDK.getDisplayLanguage(locIN));

	}
}
