import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Dates5 {
	public static void main(String[] args) throws ParseException {
		Calendar currentLocalDt = Calendar.getInstance();
		System.out.println(currentLocalDt.getTime());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//df.setTimeZone(TimeZone.getTimeZone("Asia/Dubai"));
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		String currentDtAfterFormate = df.format(currentLocalDt.getTime());
		System.out.println("currentDtAfterFormate "+currentDtAfterFormate);
		//Date currentDtAfterParse  = df.parse(currentDtAfterFormate);
		//System.out.println("currentDtAfterParse   :"+currentDtAfterParse);
	}

}
