package amplex;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
public class URLSet {
	private static final String[] urls = {
		"http://javapuzzlers.com",
		"http://yahoo.com",
		"http://google.com",
		"http://javapuzzlers.com",
		"http://findbugs",
	};
	
	public static void main(String a[]) throws MalformedURLException, URISyntaxException {
		Set<URI> url = new HashSet<URI>();
		for (int i = 0; i < urls.length; i++) {
			url.add(new URI(urls[i]));
		}
		System.out.println(url.size());
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    int hour = cal.get(Calendar.HOUR);
	    int minute = cal.get(Calendar.MINUTE);
	    int second = cal.get(Calendar.SECOND);
	    System.out.println(year+" "+(month+1)+" "+day+" "+hour+" "+minute+" "+second);
	    
	    String formattedDate = new SimpleDateFormat("yy").format(cal.getTime());
	    System.out.println("year with 2 digits:::"+formattedDate);
	    
	    StringBuffer sb = new StringBuffer();
	    Integer i = 1;
	    sb.append(String.format("%02d", i));
	    System.out.println("sb:::::::"+sb);
	    
	    
	}
}
