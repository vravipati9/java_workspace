import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Dates2 {
	public static void main(String[] args) {
		System.out.print(System.getProperty("line.separator"));
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		//cal.add(Calendar.YEAR, 1);
		System.out.println("FirstDayofWeek   :"+cal.getFirstDayOfWeek());
		System.out.println("DAY_OF_MONTH   :"+cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("DAY_OF_WEEK   :"+cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("TUESDAY   :"+Calendar.TUESDAY);
		System.out.println("cal.MONTH   :"+cal.get(Calendar.MONTH));
		System.out.println("Calendar.OCTOBER   :"+Calendar.OCTOBER);
		//cal.roll(Calendar.MONTH, 7);
		
		DateFormat[] dfa = new DateFormat[7];
		SimpleDateFormat sdf = null;
		dfa[0] = DateFormat.getInstance();							// 10/4/11 4:17 PM
		dfa[1] = DateFormat.getDateInstance();						// Oct 4, 2011
		dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT);		// 10/4/11
		dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);		// Oct 4, 2011
		dfa[4] = DateFormat.getDateInstance(DateFormat.LONG);		// October 4, 2011
		dfa[5] = DateFormat.getDateInstance(DateFormat.FULL);		// Tuesday, October 4, 2011
		Locale aLocale = new Locale("it", "CH");
		dfa[6] = DateFormat.getDateInstance(DateFormat.SHORT , aLocale);
		for(DateFormat df : dfa)
			System.out.println(df.format(cal.getTime()));
		
		sdf = new SimpleDateFormat("MMM-dd/yyyy");
		String formatedDate = sdf.format(cal.getTime());
		System.out.println("formatedDate   : "+formatedDate);
		try {
			Date afterParseDate = sdf.parse(formatedDate);
			System.out.println("afterParseDate  :"+afterParseDate.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
