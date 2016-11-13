import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;


public class DateCalculator {
    private static final String   EARLIEST_MONDAY_STRING = "01/04/2010 00:00:00";
    private static final String[] MONTH_NAME_ARRAY        =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
                                                              "November", "December" };
    private DateFormat            DATE_TIME_FORMAT        = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    private DateFormat            datePatternTypeMedium   = DateFormat.getDateInstance(DateFormat.MEDIUM);
    private TimeZone              userTimeZone = null;
    Locale userLocale = null;
    private Date                  earliestMondayDate;
    private int                   lastDayOfMonthOfCurrentMonth;
    private int currentMonth;
    private int currentYear;
    private int currentDayOfMonth;
    private int currentDayOfWeek;
    private int earliestYear;
    private int earliestMonth;
    private int maximumDaysInMonth;
    
    enum GetMonthsList{
    	January("January", 0),
    	February("February", 1),
    	March("March", 2),
    	April("April", 3),
    	May("May", 4),
    	June("June", 5),
    	July("July", 6),
    	August("August", 7),
    	September("September", 8),
    	October("October", 9),
    	November("November", 10),
    	December("December", 11);
    	
    	String month;
    	int monthId;
    	GetMonthsList(String month, int id) {
    		this.month = month;
    		this.monthId = id;
    	}
    	
    	public String getMonth() {
			return month;
		}
    	public int getMonthId() {
			return monthId;
		}
        public static String getStatusNameById(int monthId)
        {
            for (GetMonthsList statusType : GetMonthsList.values())
            {
                if (statusType.getMonthId() == monthId)
                {
                    return statusType.getMonth();
                }
            }
            return null;
        }
    }
    
    public DateCalculator()
    {
//        String[] countrysArray  = Locale.getISOCountries();
//        String[] langsArray  = Locale.getISOLanguages();
//        Locale[] locArray = Locale.getAvailableLocales();       
//        for (Locale loc : locArray) {
//        	System.out.println(loc.toString());
//        }
//        System.out.println("COUNTRY ARRAY");
//        
//        for (String countries : countrysArray) {
//        	System.out.println(countries);
//        }
//        System.out.println("LANGUAGE ARRAY");
//        for (String languages : langsArray) {
//        	System.out.println(languages);
//        }

    	userLocale = new Locale("hi", "IN");
        userTimeZone = TimeZone.getDefault();
        initializePlattsSheetDateCalculator(Calendar.getInstance(userTimeZone));
    }
    public void initializePlattsSheetDateCalculator (Calendar currentDateCalendar) {
    	System.out.println("UserLocale  :  "+  userLocale  +  "  UserTimeZone   "  +userTimeZone);
    	DATE_TIME_FORMAT.setTimeZone(userTimeZone);
    	try {
    		earliestMondayDate = DATE_TIME_FORMAT.parse(EARLIEST_MONDAY_STRING);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("earliestMondayDate>>>"+earliestMondayDate);
		Calendar earliestDate = Calendar.getInstance(userTimeZone);
		earliestDate.setTime(earliestMondayDate);
		earliestYear = earliestDate.get(Calendar.YEAR);
		earliestMonth = earliestDate.get(Calendar.MONTH);
		System.out.println("EARLIEST YEAR: "+earliestYear + "  EARLIEST MONTH:  " + earliestMonth  + "   EARLIEST DAY_OF_MONTH:  " +earliestDate.get(Calendar.DAY_OF_MONTH)  + "   EARLIEST DAY_OF_WEEK   " +earliestDate.get(Calendar.DAY_OF_WEEK) + "  EARLIER DAY_OF_WEEK_IN_MONTH  " + earliestDate.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		
		currentDateCalendar.set(Calendar.HOUR_OF_DAY, 0);
        currentDateCalendar.set(Calendar.MINUTE, 0);
        currentDateCalendar.set(Calendar.SECOND, 0);
        currentDateCalendar.set(Calendar.MILLISECOND, 0);
        Date currentDate = currentDateCalendar.getTime();
		currentYear = currentDateCalendar.get(Calendar.YEAR);
		currentMonth = currentDateCalendar.get(Calendar.MONTH);
		currentDayOfMonth = currentDateCalendar.get(Calendar.DAY_OF_MONTH);
		currentDayOfWeek = currentDateCalendar.get(Calendar.DAY_OF_WEEK);
		lastDayOfMonthOfCurrentMonth = getLastDayOfMonth(currentDate);
		System.out.println("CURRENT YEAR: "+currentYear +  "   CURRENT MONTH:  "  + currentMonth  + "   CURRENT DAY_OF_MONTH:  " +currentDayOfMonth  + "   CURRENT DAY_OF_WEEK   " +currentDayOfWeek + "  CURRENT_DAY_OF_WEEK_IN_MONTH  " + currentDateCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("lastDayOfMonthOfCurrentMonth>>>>"+lastDayOfMonthOfCurrentMonth);
		List<Integer> yearDropDown = getYearDropDown();
		List<String> monthDropDown = getMonthDropDown();
		Calendar firstMondayDate = getFirstMonday(currentYear, currentMonth);
		constructWeekList(firstMondayDate);
   }
    private void constructWeekList(Calendar firstMondayDate) {
    	System.out.println("In ConstructWeekList");
    	List<String> weekList = new ArrayList<String>();
    	
        Calendar calendar = firstMondayDate;
        Date mondayDate = calendar.getTime();
        calendar.add(Calendar.DATE, 6);
        Date sundayDate = calendar.getTime();
        
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String mondayString = df.format(mondayDate);
        String sundayString = df.format(sundayDate);      
        weekList.add(mondayString + "-" + sundayString);
        int sundayDay = calendar.get(Calendar.DAY_OF_MONTH);
        int lastDayOfMonth = getLastDayOfMonth(calendar.getTime());
        int sundayMonth = -1;
        int mondayMonth = -1;
        System.out.println("sundayDay   :"+sundayDay+"   lastDayOfMonth   :"+lastDayOfMonth);
        while (sundayMonth == mondayMonth && sundayDay != lastDayOfMonth)
        {
            // Monday
            calendar.setTime(mondayDate);
            calendar.add(Calendar.DATE, 7);
            mondayDate = calendar.getTime();
            mondayMonth = calendar.get(Calendar.MONTH);
            // Sunday
            calendar.add(Calendar.DATE, 6);
            sundayDate = calendar.getTime();
            sundayMonth = calendar.get(Calendar.MONTH);
            sundayDay = calendar.get(Calendar.DAY_OF_MONTH);

            mondayString = df.format(mondayDate);
            sundayString = df.format(sundayDate);
            weekList.add(mondayString + "-" + sundayString);
        }
    	for (String str : weekList) {
    		System.out.println("values  :"+str);
    	}

    }

    private Calendar getFirstMonday(int year, int month) {
    	System.out.println("Year>>>"+year+"   month   "+month);
    	Calendar calendar = Calendar.getInstance(userTimeZone);
     	calendar.set(Calendar.YEAR, year);
    	calendar.set(Calendar.MONTH, month);
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
    	Date newDate = calendar.getTime();
    	  System.out.println("newDate>>>>"+newDate);
    	System.out.println("YEAR SET : "+calendar.get(Calendar.YEAR));
    	//int i = calendar.
    	System.out.println("MONDAY : "+Calendar.MONDAY+ "  DAY_OF_WEEK  "+calendar.get(Calendar.DAY_OF_WEEK));
    	System.out.println("TUESDAY : "+Calendar.TUESDAY+ "  DAY_OF_WEEK  "+calendar.get(Calendar.DAY_OF_WEEK));
    	System.out.println("WEDNESDAY : "+Calendar.WEDNESDAY+ "  DAY_OF_WEEK  "+calendar.get(Calendar.DAY_OF_WEEK));
    	System.out.println("THURSDAY : "+Calendar.THURSDAY+ "  DAY_OF_WEEK  "+calendar.get(Calendar.DAY_OF_WEEK));
    	System.out.println("FRIDAY : "+Calendar.FRIDAY+ "  DAY_OF_WEEK  "+calendar.get(Calendar.DAY_OF_WEEK));
    	System.out.println("SATURDAY : "+Calendar.SATURDAY+ "  DAY_OF_WEEK  "+calendar.get(Calendar.DAY_OF_WEEK));
    	System.out.println("SUNDAY : "+Calendar.SUNDAY+ "  DAY_OF_WEEK  "+calendar.get(Calendar.DAY_OF_WEEK));
		
		if (Calendar.MONDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
			// calendar.set(Calendar.DATE, 0);
			System.out.println("MONDAY   : "+calendar.getTime());
		} else if (Calendar.TUESDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
			calendar.add(Calendar.DATE, 6); // the first Monday of the month
			calendar.add(Calendar.DATE, -7); // the last Monday of prior month
			System.out.println("TUESDAY   : "+calendar.getTime());
		} else if (Calendar.WEDNESDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
			calendar.add(Calendar.DATE, 5); // the first Monday of the month
			calendar.add(Calendar.DATE, -7); // the last Monday of prior month
			System.out.println("WEDNESDAY   : "+calendar.getTime());
		} else if (Calendar.THURSDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
			calendar.add(Calendar.DATE, 4); // the first Monday of the month
			calendar.add(Calendar.DATE, -7); // the last Monday of prior month
			System.out.println("THURSDAY   : "+calendar.getTime());
		} else if (Calendar.FRIDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
			calendar.add(Calendar.DATE, 3); // the first Monday of the month
			calendar.add(Calendar.DATE, -7); // the last Monday of prior month
			System.out.println("FRIDAY   : "+calendar.getTime());
		} else if (Calendar.SATURDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
			calendar.add(Calendar.DATE, 2); // the first Monday of the month
			calendar.add(Calendar.DATE, -7); // the last Monday of prior month
			System.out.println("SATURDAY   : "+calendar.getTime());
		} else if (Calendar.SUNDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
			calendar.add(Calendar.DATE, 1); // the first Monday of the month
			calendar.add(Calendar.DATE, -7); // the last Monday of prior month
			System.out.println("SUNDAY   : "+calendar.getTime());
		}
		return calendar;
    }

    private int getLastDayOfMonth(Date iDate)
    {
        Calendar calendar = Calendar.getInstance(userTimeZone);
        calendar.setTime(iDate);
        int lastDate = calendar.getActualMaximum(Calendar.DATE);
        System.out.println("lastDate>>"+lastDate);
        System.out.println("lastMonth>>"+calendar.getActualMaximum(Calendar.MONTH));
        calendar.set(Calendar.DATE, lastDate);
        System.out.println("calendar.getTime()  :  "+calendar.getTime());
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
    public List<Integer> getYearDropDown()
    {
        int startYear;
        if (currentMonth == 11)
        {
            // We are in the last month of the year
            startYear = currentYear + 1;
        }
        else
        {
            startYear = currentYear;
        }
        List<Integer> yearList = new ArrayList<Integer>();
        
        for (; startYear >= earliestYear; startYear--)
        {
            //nv = new NameValue(String.valueOf(startYear), String.valueOf(startYear));
            yearList.add(startYear);
        }
        System.out.println("PlattsSheetDateCalculator.getYearDropDown() nv: " + startYear);
        return yearList;
    }
    
    public List<String> getMonthDropDown()
    {
    	List<String> monthList  = new ArrayList<String>();
        int startMonth;
        int endMonth;
       
    	if (currentMonth < 11) {
        	startMonth = 0;
        	endMonth = currentMonth; 
        } else {
        	startMonth = 0;endMonth = 11;
        }
    
    	for (;startMonth<= endMonth; startMonth++) {
    		//monthList.add(MONTH_NAME_ARRAY[startMonth]);
    		monthList.add(GetMonthsList.getStatusNameById(startMonth));
    	}
    	System.out.println("PlattsSheetDateCalculator.getMonthDropDown() nv: " + monthList);
    	return monthList;
    }

    public static void main(String a[]) {
	   DateCalculator dc = new DateCalculator();	   
   }
    
}

