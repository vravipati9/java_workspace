import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class GetCurrentTimeZone {

  public static void main(String[] args) {
    Calendar now = Calendar.getInstance();
    TimeZone timeZone = now.getTimeZone();
    
    System.out.println("Current TimeZone is : " + timeZone.getTimeZone("India"));
    
  }
}