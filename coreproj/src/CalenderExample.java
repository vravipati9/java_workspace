import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class CalenderExample {

	private static void getTimewith24hourFormat() {

		System.out.println("Performing operations on calendar dates.");

		Calendar date = Calendar.getInstance();
		System.out.println(date);
		
		int i = date.get(Calendar.HOUR_OF_DAY);
		System.out.println(i);
	}

	public static void main(String[] args) {
		getTimewith24hourFormat();
	}
} 
