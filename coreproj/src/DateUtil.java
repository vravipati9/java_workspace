import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import com.netjets.logistics.dto.FBO;
import com.netjets.util.date.AirportTimeZone;
import com.netjets.util.date.AirportTimeZoneUtil;

/**
 * Copyright(c) 2005, Pallas Technology.<br><br>
 * 
 * $Archive: NetJets$<br>
 * $FileName: DateUtil.java$<br>
 * $FileID: 4632$<br>
 * $Description: $<br>
 * $Location:
 *           NetJets/Crossroads2/dev/deployment-2/modules/common/java/com/netjets/crossroads/util$<br><br>
 *
 * Last change:<br>
 * $AuthorName: Rob MacGrogan$<br>
 * $Date: 1/6/06 10:44 AM$<br>
 * $Comment: $<br><br>
 * 
 * @author $AuthorName: Rob MacGrogan$<br>
 * @version $VerNum: 9$ <br>
 * $KeyWordsOff: $<br><br>
 */
public class DateUtil {

  /**
   * Full date with day of week: Wednesday 11/30/2005
   */
  public static final String FORMAT_DATE_WITH_DAY_OF_WEEK = "E MM/dd/yyyy";
  
  /**
   * Full time with time zone: 11:11 EST
   */
  public static final String FORMAT_TIME_WITH_TZ_WITH_12_HRS = "HH:mm z (hh:mm a)";

  /**
   * Full time with time zone: 11/30/2005 11:11 EST
   */
  public static final String FORMAT_DATE_TIME_WITH_TZ = "MM/dd/yyyy HH:mm z";
  
  /**
   * Full date and time: 11/30/2005 11:11
   */
  public static final String FORMAT_DATE_TIME = "MM/dd/yyyy HH:mm";
  
  /**
   * Full date without time: 11/30/2005
   */
  public static final String FORMAT_DATE = "MM/dd/yyyy";

  /**
   * Apply any arbitrary format to a date. No special time zone manipulation
   * is done, so date is formatted in server's time zone.
   * 
   * @param date
   * @param format
   * @return
   * @deprecated - Use LocalizationFormatter.
   */
  @Deprecated
  public static String applyFormatToDate(Date date, String format) {
    SimpleDateFormat formatter = new SimpleDateFormat(format);
    return formatter.format(date);
  }
  
  /**
   * Returns a formatted date string in the time zone of the FBO, using the
   * passed in date format (MM/dd/yyyy, that sort of thing).
   * @param dateTime
   * @param fbo
   * @param format
   * @return
   */
  public static String fboDateTimeString(Date dateTime, FBO fbo, String format) {
    DateFormat formatter = fboDateFormat(fbo, format);
    String sDate = formatter.format(dateTime);
    return sDate;
  }
  
  /**
   * Returns a formatted date string in the time zone , using the
   * passed in date format (MM/dd/yyyy, that sort of thing).
   * @param dateTime
   * @param tz
   * @param format
   * @return
   * @deprecated - Use LocalizationFormatter.
   */
  @Deprecated
  public static String tzDateTimeString(Date dateTime, TimeZone tz, String format) {
    DateFormat formatter = tzDateFormat(tz, format);
    String sDate = formatter.format(dateTime);
    return sDate;
  }

  /**
   * Creates a DateFormat object that can parse dates in the FBO's proper time zone.
   * @param fbo
   * @param format
   * @return
   */
  public static DateFormat fboDateFormat(FBO fbo, String format) {
    SimpleDateFormat formatter = new SimpleDateFormat(format);
    TimeZone tz = getFboTimeZone(fbo);
    formatter.setTimeZone(tz);
    return formatter;
  }
  
  /**
   * Creates a DateFormat object that can parse dates in the proper time zone.
   * @param tz
   * @param format
   * @return
   * @deprecated - Use LocalizationFormatter.
   */
  @Deprecated
  public static DateFormat tzDateFormat(TimeZone tz, String format) {
    SimpleDateFormat formatter = new SimpleDateFormat(format);
    formatter.setTimeZone(tz);
    return formatter;
  }
  
  /**
   * Parses a string date in the FBO's timezone to a Date object, using
   * the format passed in.
   * 
   * @param dateTime
   * @param fbo
   * @param format
   * @return
   * @throws ParseException
   */
  public static Date fboDateTimeStringToDate(String dateTime, FBO fbo, String format) 
          throws ParseException {
    DateFormat formatter = fboDateFormat(fbo, format);
    Date d = formatter.parse(dateTime);
    return d;
  }
  
  /**
   * Parses a string date in the FBO's timezone to a Date object, using
   * the format passed in.
   * 
   * @param dateTime
   * @param tz
   * @param format
   * @return
   * @throws ParseException
   * @deprecated - Use LocalizationFormatter.
   */
  @Deprecated
  public static Date tzDateTimeStringToDate(String dateTime, TimeZone tz, String format) 
          throws ParseException {
    DateFormat formatter = tzDateFormat(tz, format);
    Date d = formatter.parse(dateTime);
    return d;
  }
  
  /**
   * Creates the TimeZone object representing the TimeZone of the 
   * FBO.
   * 
   * @param fbo
   * @return
   */
  public static TimeZone getFboTimeZone(FBO fbo) {
    AirportTimeZone apt = new AirportTimeZone();
    //Only set DST info for TZs that support DST.
    if (fbo.getAirportTimeZone().getDaylightSavingEnd() != null) {
        apt.setDaylightSavingEnd(fbo.getAirportTimeZone().getDaylightSavingEnd().toDate());
        apt.setDaylightSavingStart(fbo.getAirportTimeZone().getDaylightSavingStart().toDate());
        apt.setDaylightSavingHours(fbo.getAirportTimeZone().getDaylightSavingHours());
    }
    apt.setHoursToGMT((int)fbo.getAirportTimeZone().getHoursToGMT());
    apt.setId(fbo.getAirportTimeZone().getId());
    TimeZone tz = AirportTimeZoneUtil.getTimeZone(apt);
    return tz;
    
  }
  
  /**
   * Returns a new Date with the same calendar date as the Date passed in, 
   * but with the time changed to 12:00 AM in the newTimeZone specified.
   */
  public static Date stripTime(Date dt, TimeZone newTimeZone) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(dt);
    int year  = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int day   = cal.get(Calendar.DAY_OF_MONTH);

    Calendar calStripped = Calendar.getInstance();
    calStripped.clear();
    if (newTimeZone!=null) {
      calStripped.setTimeZone(newTimeZone);
    }
    calStripped.set(year, month, day);

    return calStripped.getTime(); 
  }
  
  /**
   * Returns a new Date with the same calendar date as the Date passed in, 
   * but with the time changed to 12:00 AM.
   */
  public static Date stripTime(Date dt) {
    return stripTime(dt,TimeZone.getDefault()); 
  }
  
  /**
   * Date math function.
   * 
   * @param date -- the Date to be shifted.
   * @param datePart -- part of a date (Month, day, etc.) Use Calendar constants.
   * @param shift -- signed shift. -1 subtracts 1. 1 adds one, etc.
   */
  public static Date dateShift(Date date, int datePart, int shift) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(datePart, shift);
    return cal.getTime();
  }
  

  public static String formatServerDateTime(Date date) {
      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm z");
      String sDate = formatter.format(date);
      return sDate;
    }
    
    
    private static final int STANDARD = 0;
    private static final int DAYLIGHT = 1;
    
    private static final int MILLIS_TO_HOURS = 1000 * 60 * 60; 
    
    private static final String[] FOUR = {"AST", "EDT"};
    private static final String[] FIVE = {"EST", "CDT"};
    private static final String[] SIX = {"CST", "MDT"};
    private static final String[] SEVEN = {"MST", "PDT"};
    private static final String[] EIGHT = {"PST", "AKDT"};
    private static final String[] NINE = {"AKST", "HADT"};
    private static final String[] TEN = {"HAST", "X"};
    
    private static Map tzAbbreviationMap = new HashMap();
    static {
        tzAbbreviationMap.put(new Integer(-4), FOUR);
        tzAbbreviationMap.put(new Integer(-5), FIVE);
        tzAbbreviationMap.put(new Integer(-6), SIX);
        tzAbbreviationMap.put(new Integer(-7), SEVEN);
        tzAbbreviationMap.put(new Integer(-8), EIGHT);
        tzAbbreviationMap.put(new Integer(-9), NINE);
        tzAbbreviationMap.put(new Integer(-10), TEN);
    }
    
    /**
     * Returns the appropriate time zone abbreviation (EST, PDT, etc)
     * for the given time and TimeZone. We assume that the time zone does
     * not have a description associated with it. This method only works for US
     * time zones. All others will return the default short description from
     * time TimeZone object, something like GMT - 5:00.
     * 
     * @param time
     * @param tz
     * @return
   * @deprecated - Use LocalizationFormatter and TimeZoneAbbreviationConverter.
   */
  @Deprecated
    public static String getUSTimeZoneAbbreviation(Date time, TimeZone tz) {
        int gmtOffsetMillis = tz.getOffset(time.getTime());
        int gmtOffsetHours = gmtOffsetMillis / MILLIS_TO_HOURS;
        String[] tzAbbrevSet = (String[])tzAbbreviationMap.get(new Integer(gmtOffsetHours));
        String abbrev = null;
        if (tz.inDaylightTime(time)) {
            if (tzAbbrevSet != null) {
                abbrev = tzAbbrevSet[DAYLIGHT];
            }
            else {
                abbrev = tz.getDisplayName(true, TimeZone.SHORT);
            }
        }
        else {
            if (tzAbbrevSet != null) {
                abbrev = tzAbbrevSet[STANDARD];
            }
            else {
                abbrev = tz.getDisplayName(false, TimeZone.SHORT);
            }
        }
        return abbrev;
    }

    /**
     * Any format passed in to this method should NOT include the tz. This method
     * will append the US time zone abbrevious (see the getUSTimeZoneAbbreviation() 
     * method) to the formatted string. 
     * 
     * @param date
     * @param tz
     * @param rawFormat
     * @return
   * @deprecated - Use LocalizationFormatter.
   */
  @Deprecated
    public static String formatUSDateWithTimeZone(Date date, TimeZone tz, String rawFormat) {
        DateFormat format = tzDateFormat(tz, rawFormat);
        String rawFormattedDate = format.format(date);
        String tzAbbrev = getUSTimeZoneAbbreviation(date, tz);
        return rawFormattedDate + " " + tzAbbrev;
    }
    
    /**
     * This method will return a start date based on an endDate and
     * the number of days needed in the search range.
     * 
     * 
     * @param endDate
     * @return startDate 
     */
    public static String calculateDefaultStartDate(Date endDate, int dateRange) {
        String startDate = applyFormatToDate((dateShift(endDate, Calendar.DAY_OF_MONTH, dateRange)),FORMAT_DATE);
        
        return startDate;
    }    
    
    /**
     * @param assumedDate
     * @param actualTimeZone
     * @return
     * This method should be used with MIC importer and invoice importer. When POI imports, it assumes the server timezone.
     * Yet the values have been entered with a different timezone (actualTimeZone). 
     * This method corrects assumedDate by altering it by the difference in incorrectly assuming server timezone. 
     */
    public static void shiftAssumedServerTimeToTimezone(Date assumedDate, TimeZone actualTimeZone) {
        TimeZone serverTimeZone = TimeZone.getDefault();
        shiftTimeToDifferentTimezone(assumedDate, serverTimeZone, actualTimeZone);
    }
    
    /**
     * @param assumedDate
     * @param actualTimeZone
     * This method should be used with MIC exporter. It shifts the date so that the exporter will export it with the server timezone.
     * For example, if the time is 4 PM PST but server timezone is EST, this will shift it to 1PM PST 
     * so that the export will export it as 4 PM (implied EST) and 4 PM will show to the user.
     */
    public static void shiftTimeToAssumedServerTimezone(Date assumedDate, TimeZone actualTimeZone) {
        TimeZone serverTimeZone = TimeZone.getDefault();
        shiftTimeToDifferentTimezone(assumedDate, actualTimeZone, serverTimeZone);
    }
    
    public static void shiftTimeToDifferentTimezone(Date date, TimeZone tzOriginal, TimeZone tzNew) {
        int tzOriginalOffset = tzOriginal.getOffset(date.getTime());
        int tzNewOffset = tzNew.getOffset(date.getTime());        
        int difference = tzOriginalOffset - tzNewOffset;
        Date updatedDate = null;
        if (difference!=0) {
            updatedDate = dateShift(date, Calendar.MILLISECOND, difference);
           // Because of DST we might have a different newTimeZoneOffset than we thought if the time has moved to another day.
           int differenceInNewTimeZoneOffset = -tzNew.getOffset(updatedDate.getTime()) + tzNewOffset;
           if (differenceInNewTimeZoneOffset!=0) {
               updatedDate = dateShift(updatedDate, Calendar.MILLISECOND, differenceInNewTimeZoneOffset);    
           }
           date.setTime(updatedDate.getTime());
        }
    }
    
    /**
     * This method will return a Zulu TimeZOne which is to be used as a default
     * TimeZone.
     */
    public static TimeZone getZuluTimeZone()
    {
        return TimeZone.getTimeZone("Zulu");
    }
    
    /**
     * Returns the difference between two passed date in hours.
     * if return value is +ve than first date is prior to second one.
     * if return value is -ve than second date is prior to first one.
     * @param Date firstDate
     * @param Date secondDate
     * @return double
     */
    public static double getDateDiffInHours(Date firstDate, Date secondDate)
    {
        long firstDateInMillsecs = firstDate.getTime();
        long secodDateInMillsecs = secondDate.getTime();
        long dateDifference = firstDateInMillsecs - secodDateInMillsecs;
        BigDecimal msecs = new BigDecimal(Long.toString(dateDifference));
        double val = msecs.doubleValue() / (1000 * 60 * 60);
        return val;
    }   
    
    /**
     * QC 40852 - bnovak2 
     * Null safe comparison of dates 
     * 
     * This method will return true if the dates are equal or are both null
     * If the dates are unequal or if only one of them is null, it will return false
     * 
     * @param Date firstDate
     * @param Date secondDate
     * @return boolean - true if dates are equal; false if not
     */
    public static boolean equals(Date firstDate, Date secondDate)
    {
        boolean datesAreEqual = false;
        
        if (firstDate == null && secondDate == null)
        {
            datesAreEqual = true;
        }
        else if (firstDate == null && secondDate != null)
        {
            datesAreEqual = false;
        }
        else if (firstDate != null && secondDate == null)
        {
            datesAreEqual = false;
        }
        else
        {
            datesAreEqual = firstDate.equals(secondDate);
        }
        
        return datesAreEqual;
    }
    
    /**
     * QC 35896 
     * Null safe comparison of date years 
     * 
     * This method will return true if the date years are equal or are both null
     * If the date years are unequal or if only one of them is null, it will return false
     * Dates are assumed to be interpreted as GMT
     * 
     * @param Date firstDate
     * @param Date secondDate
     * @return boolean - true if dates are equal; false if not
     */
    public static boolean yearEquals(Date firstDate, Date secondDate)
    {
        Integer firstDateYear = null;
        Integer secondDateYear = null;
        GregorianCalendar gmtCal = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        if (firstDate != null)
        {
            gmtCal.setTime(firstDate);
            firstDateYear = new Integer(gmtCal.get(Calendar.YEAR));
        }
  
        if (secondDate != null)
        {
            gmtCal.setTime(secondDate);
            secondDateYear = new Integer(gmtCal.get(Calendar.YEAR));
        }
        
        boolean datesAreEqual = false;
        
        if (firstDateYear == null && secondDateYear == null)
        {
            datesAreEqual = true;
        }
        else if (firstDateYear == null && secondDateYear != null)
        {
            datesAreEqual = false;
        }
        else if (firstDateYear != null && secondDateYear == null)
        {
            datesAreEqual = false;
        }
        else
        {
            datesAreEqual = firstDateYear.equals(secondDateYear);
        }
        
        return datesAreEqual;
    }
    
}