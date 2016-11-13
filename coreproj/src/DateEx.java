import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class DateEx {

	/**
	 * @param args
	 * @throws java.text.ParseException 
	 */
	public static void main(String[] args) throws java.text.ParseException {
        SimpleDateFormat simpleDateFormate = new SimpleDateFormat("MM/dd/yyyy");
        TimeZone tz = TimeZone.getDefault();
        TimeZone tz1 = TimeZone.getTimeZone("Zulu");
        TimeZone tz2 = TimeZone.getTimeZone("America/Los_Angeles");
        Date now = new Date();
        System.out.println("date..."+now);
        
        simpleDateFormate.setTimeZone(tz);
        String gmtDateString = simpleDateFormate.format(now);
        System.out.println("default TimeZone..."+ gmtDateString);
        
        simpleDateFormate.setTimeZone(tz1);
        System.out.println("Zulu TimeZone..."+ simpleDateFormate.format(now));
        
        simpleDateFormate.setTimeZone(tz2);
        System.out.println("America/LosAngles TimeZone..."+ simpleDateFormate.format(now));
        
        SimpleDateFormat localFormat = new SimpleDateFormat("mm/dd/yyyy");
        Date localDate = localFormat.parse(gmtDateString);
        System.out.println("default TimeZone..."+localDate);
	}

}
