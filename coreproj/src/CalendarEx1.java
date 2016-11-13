import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class CalendarEx1 {
	public static void main(String[] args) {
		

	}

public static Date getLastDateOfMonth(String iMonthYear, String iTimezone)
{
    StringTokenizer st = new StringTokenizer(iMonthYear,"-");
    String iMonth = st.nextToken();
    String iYear  = st.nextToken();
    
    // Get First day of next month
    GregorianCalendar gcDate = new GregorianCalendar(
            Integer.parseInt(iYear),
            Integer.parseInt(iMonth),
            1);
    gcDate.setTimeZone(TimeZone.getTimeZone(iTimezone));
    
    // Subtract on day
    gcDate.add(GregorianCalendar.DATE, -1);
    
    return gcDate.getTime();
}

public static String getLastDateOfMonthString(String iMonthYear, String iTimezone)
{
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    
    return formatter.format( getLastDateOfMonth(iMonthYear, iTimezone) );
}


public static String removeRepeatingAsterics(String iStr) 
{
    if (iStr == null || iStr.trim().equals(""))
    {
        return iStr;
    }
    
    StringBuffer sb = new StringBuffer();
    char[] cArray = iStr.toCharArray();
    char   pChar  = ' ';
    for (int i = 0; i < cArray.length; i++) 
    {
        if ( cArray[i] == '*' && pChar == '*' )
        {
            //skip
        } else {
            sb.append(cArray[i]);
        }
        pChar = cArray[i];
    }
    
    return sb.toString();
}

public static String removeNonAlphabeticCharacters(String iStr) 
{
    if (iStr == null || iStr.trim().equals(""))
    {
        return iStr;
    }
    
    StringBuffer sb = new StringBuffer();
    char[] cArray = iStr.toCharArray();
    for (int i = 0; i < cArray.length; i++) 
    {
        if (   (cArray[i] >= 'a' && cArray[i] <= 'z')
            || (cArray[i] >= 'A' && cArray[i] <= 'Z') )
        {
            sb.append(cArray[i]);
        }
    }
    
    return sb.toString();
}
}



