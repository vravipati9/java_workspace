import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/*
 * 	Given that 1119280000000L is roughly the number of milliseconds from Jan. 1, 1970, to June
	20, 2005, and that you want to print that date in German, using the LONG style such that "June"
	will be displayed as "Juni", complete the code using the fragments below. Note: you can use
	each fragment either zero or one times, and you might not need to fill all of the slots.
 */
public class DateTwo {

	public static void main(String[] args) {
		Date d = new Date(1119280000000L);
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.GERMAN);
		String formatedDate = df.format(d);
		System.out.println(formatedDate);
	}

}
