import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Dates4 {
	public static void main(String[] args) {
		Locale locIT = new Locale("it", "IT"); // Italy
		Locale locPT = new Locale("pt"); // Portugal
		Locale locBR = new Locale("pt", "BR"); // Brazil
		
		Calendar cal = Calendar.getInstance();
		Calendar brazilCal = Calendar.getInstance(locIT);
		TimeZone tz = brazilCal.getTimeZone();
		String[] tzIds = tz.getAvailableIDs();
		System.out.println("Normal Cal   :  "+cal.getTime());
		System.out.println("Brazil Cal   :  "+brazilCal.getTime());
		System.out.println("Brazil Tz    :  "+Arrays.asList(tzIds));
		System.out.println("tz.getDisplayName   :  "+tz.getDisplayName());
		System.out.println("tz.getID()   :  "+tz.getID());

		String[] timeZoneIDList = TimeZone.getAvailableIDs();   //List of Time Zones
		for(String timeZoneID:timeZoneIDList) {  
			//System.out.println(timeZoneID);         
		}
		TimeZone bangtz = TimeZone.getTimeZone("Asia/Bangkok");
		Calendar asiaBangkokCalendar = Calendar.getInstance(bangtz);
		System.out.println("---"+asiaBangkokCalendar.get(Calendar.HOUR)+"---"+asiaBangkokCalendar.get(Calendar.MINUTE));
		
		DateFormat df = DateFormat.getInstance();
		df.setTimeZone(bangtz);
		System.out.println("local Time  :"+cal.getTime());
		System.out.println(df.format(cal.getTime()));
	}

}
