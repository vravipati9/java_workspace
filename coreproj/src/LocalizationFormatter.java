package com.netjets.crossroads.common.localization;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

import com.netjets.crossroads.common.localization.UserLocale.DatePattern;
import com.netjets.crossroads.util.DateUtil;


/**
 * This class formats and parses Numbers and Dates for a given locale.
 * 
 * Instances of this class should be obtained from LocalizationFormatterFactory.
 */
public class LocalizationFormatter
{
    private static String decimalPattern = "#,###,##0.00";
    private static String integerPattern = "####";
    private DecimalFormat decimalFormatter = null;
    private NumberFormat integerFormatter = null;
    private Locale localeForDates = null;
    
    public enum DatePatternType {
        
        /* Be careful in re-ordering the following list of types.
         * The parseStringToDate() methods run through the date patterns
         * in the order below, and current order appears to be optimal. Re-run
         * the ObjectConverterTest upon re-ordering.
         */
        MEDIUM_DATE_W_TWENTYFOUR_HR_TIME_AND_TZ(DatePattern.MEDIUM_W_24_HR_TIME, true),
        MEDIUM_DATE_W_TWENTYFOUR_HR_TIME(DatePattern.MEDIUM_W_24_HR_TIME, false),
        SHORT(DatePattern.SHORT, false),
        SHORT_FULL_YEAR(DatePattern.SHORT_FULL_YEAR, false),
        MEDIUM_SHORT_YEAR(DatePattern.MEDIUM_SHORT_YEAR, false),
        MEDIUM(DatePattern.MEDIUM, false),
        MEDIUM_WITH_DAY_OF_WEEK(DatePattern.MEDIUM_W_DOW, false),
        RAW(DatePattern.RAW, false),
        FULL(DatePattern.FULL, false),
        TWELVE_HR_TIME_W_TZ(DatePattern.TWELVE_HOUR_TIME, true),
        TWENTYFOUR_HR_TIME_W_TZ(DatePattern.TWENTYFOUR_HOUR_TIME, true);
        
        private boolean includeTz = false;
        private DatePattern pattern = null;
        
        DatePatternType(DatePattern pattern, boolean includeTz) {
            this.pattern = pattern;
            this.includeTz = includeTz;
        }
        
        boolean isIncludeTz() {
            return includeTz;
        }
        
        DatePattern getUserLocalePattern() {
            return this.pattern;
        }
    }

    private UserLocale userLocale = null;
    
    /**
     * Constructs a new formatter. This constructor should not be called directly.
     * Use the LocalizationFormatterFactory instead.
     */
    LocalizationFormatter(UserLocale userLocale) {
        this.userLocale = userLocale;
        //Only English language is supported for dates.
        this.localeForDates = new Locale("en", userLocale.getCountryCode());
        
        this.decimalFormatter = new DecimalFormat(decimalPattern, new DecimalFormatSymbols(userLocale.getLocale()));
        this.decimalFormatter.setMinimumFractionDigits(2);
        this.decimalFormatter.setMaximumFractionDigits(2);
        
        this.integerFormatter = new DecimalFormat(integerPattern, new DecimalFormatSymbols(userLocale.getLocale()));
        this.integerFormatter.setMinimumFractionDigits(0);
        this.integerFormatter.setMaximumFractionDigits(0);
    }
    
    /**
     * Returns the local decimal separator for numbers, such as a comma or dot.
     */
    public String getDecimalSeparator() {
        return "" + decimalFormatter.getDecimalFormatSymbols().getDecimalSeparator();
    }

    /**
     * Returns the local grouping separator for numbers, such as a comma, dot, or space.
     */
    public String getGroupingSeparator() {
        return "" + decimalFormatter.getDecimalFormatSymbols().getGroupingSeparator();
    }
    
    /**
     * Formats Date to a String for the locale (US or Europe) in use
     * by this class. Defaults pattern to MEDIUM.
     */
    public String formatDate(Date date) {
        return formatDate(date, DatePatternType.MEDIUM, null);
    }
    
    /**
     * Formats Date to a String for the locale (US or Europe) in use
     * by this class. Defaults pattern to MEDIUM.
     */
    public String formatDate(Date date, TimeZone tz) {
        return formatDate(date, DatePatternType.MEDIUM, tz);
    }

    /**
     * Formats Date to a String for the locale (US or Europe) in use
     * by this class, using the pattern type passed in.
     */
    public String formatDate(Date date, DatePatternType pattern) {
        return formatDate(date, pattern, null);
    }
    
    /**
     * Formats Date to a String for the locale (US or Europe) in use
     * by this class, using the pattern type passed in. If this method is
     * called and the date pattern includes a time zone and no time zone
     * is passed in to this method, the method used the server default
     * TimeZone.
     * 
     * If the date passed in is null, this method returns empty string.
     */
    public String formatDate(Date date, DatePatternType pattern, TimeZone tz) {
        StringBuffer str = new StringBuffer();
        if (date != null) {
            if (tz == null) {
                //Use default Zulu tz.
                tz = DateUtil.getZuluTimeZone();
            }
            String datePattern = getDatePattern(pattern);
            DateFormat format = getDateFormatter(datePattern, tz);
            String baseFormattedDate = format.format(date);
            str.append(baseFormattedDate);
            //If we need to append timezone, look up time zone abbrv using abbreviator.
            if (pattern.isIncludeTz()) {
                String tzAbbr = TimeZoneAbbreviationConverter.getTimeZoneAbbreviation(date, tz);
                str.append(" ").append(tzAbbr);
            }
        }
        return str.toString();
    }

    /**
     * Parses the string passed in to a date. Loops through all date 
     * locale-specific patterns defined in this class. Throws ParseException
     * if String cannot be parsed to a date in the current locale.
     * 
     * This methos uses the default server timezone to parse the date.
     */
    public Date parseStringToDate(String string) 
                throws ParseException {
        return parseStringToDate(string, null, true);
    }
    
    /**
     * Parses the string passed in to a date. Loops through all date 
     * locale-specific patterns defined in this class. Throws ParseException
     * if String cannot be parsed to a date in the current locale. 
     * 
     * If string is null or empty, returns null.
     */
    public Date parseStringToDate(String string, TimeZone tz) 
                throws ParseException {
        return parseStringToDate(string, tz, true);
    }
    
    /**
     * Parses the string passed in to a date. Loops through all date 
     * locale-specific patterns defined in this class. Throws ParseException
     * if String cannot be parsed to a date in the current locale.
     * <b>Lenient </b>
     * Specifies whether or not date/time interpretation is to be lenient. With
     * lenient interpretation, a date such as "February 942, 1996" will be
     * treated as being equivalent to the 941st day after February 1, 1996. With
     * strict (non-lenient) interpretation, such dates will cause an exception
     * to be thrown. The default is lenient.
     * 
     * @param lenient
     *            <code>true</code> if the lenient mode is to be turned on;
     *            <code>false</code> if it is to be turned off.
     * 
     * @see java.util.Calendar#isLenient()
     * 
     * @see java.text.DateFormat#setLenient 
     *      
     * This methos uses the default server timezone to parse the date.
     */
    public Date parseStringToDate(String string, boolean lenient) 
                throws ParseException {
        return parseStringToDate(string, null, lenient);
    }
    
    /**
     * Parses the string passed in to a date. Loops through all date
     * locale-specific patterns defined in this class. Throws ParseException if
     * String cannot be parsed to a date in the current locale. 
     * <b>Lenient </b>
     * Specifies whether or not date/time interpretation is to be lenient. With
     * lenient interpretation, a date such as "February 942, 1996" will be
     * treated as being equivalent to the 941st day after February 1, 1996. With
     * strict (non-lenient) interpretation, such dates will cause an exception
     * to be thrown. The default is lenient.
     * 
     * @param lenient
     *            <code>true</code> if the lenient mode is to be turned on;
     *            <code>false</code> if it is to be turned off.
     * 
     * @see java.util.Calendar#isLenient()
     * 
     * @see java.text.DateFormat#setLenient 
     * 
     * @return Date If string is null or empty, returns
     *      null.
     */
    public Date parseStringToDate(String string, TimeZone tz, boolean lenient) 
                throws ParseException {
        Date d = null;
        if (! StringUtils.isEmpty(string)) {
            boolean successfulParse = false;
            DatePatternType[] patterns = DatePatternType.values();
            for (int i = 0; i < patterns.length && !successfulParse; i++) {
                DatePatternType pattern = patterns[i];
                DatePattern userLocalePattern = pattern.getUserLocalePattern();
                String datePattern = userLocale.getPatternString(userLocalePattern);
                DateFormat formatter = getDateFormatter(datePattern, tz);
                formatter.setLenient(lenient);
                try{
                  d = formatter.parse(string);
                  successfulParse = true;
                }
                catch(ParseException ex){
                  //try again.
                }
            }
            if (d == null){
                throw new ParseException("Can't parse string " + string + " to a date.", 0);
            }
        }
        return d;
    }
    
    /**
     * Formats the number to a String, using 2 decimal places, according to the
     * current locale.
     * 
     *  If number is null, this method returns empty String.
     */
    public String formatDecimal(Number number) {
        String s = null;
        if (number != null) {
            s = decimalFormatter.format(number.doubleValue()); 
        }
        else {
            s = "";
        }
        return s;
    }
    
    /**
     * Formats the number to a String using the number of decimal places
     * passed in as the max. If fixedDecimal is true then pads out the 
     * decimals with 0s to the max value.
     *
     * For example:
     * number = 9999.999
     * maxDecimals = 4
     * fixedDecimal = true
     * result = 9,999.9990
     */
    public String formatDecimal(Number number, int maxDecimals, boolean fixedDecimal)
    {
        String s = null;
        if (number != null)
        {
            DecimalFormat df = new DecimalFormat(decimalPattern, new DecimalFormatSymbols(userLocale.getLocale()));
            df.setMaximumFractionDigits(maxDecimals);
            if (fixedDecimal)
            {
                df.setMinimumFractionDigits(maxDecimals);
            }
            s = df.format(number.doubleValue());
        }
        return s;
        
    }
    
    /**
     * Formats the number to a String using the number of decimal places
     * passed in as the minDecimals and maxDecimals.
     *
     * For example:
     * number = 9999.00
     * maxDecimals = 4
     * minDecimals = 0
     * result = 9,999
     */
    public String formatDecimal(Number number,int minDecimals, int maxDecimals)
    {
        String s = null;
        if (number != null)
        {
            DecimalFormat df = new DecimalFormat(decimalPattern, new DecimalFormatSymbols(userLocale.getLocale()));
            df.setMaximumFractionDigits(maxDecimals);
            df.setMinimumFractionDigits(minDecimals);
            s = df.format(number.doubleValue());
        }
        return s;
        
    }
    
    
    /**
     * Returns null if string is null or empty.
     */
    public Double parseStringToDouble(String string) throws ParseException {
        Double d = null;
        if (! StringUtils.isEmpty(string)) {
            Number n = this.decimalFormatter.parse(string);
            //Not sure if this is Double or not, so we convert.
            d = new Double(n.toString());
        }
        return d;
    }
    
    /**
     * Returns null if string is null or empty.
     */
    public Float parseStringToFloat(String string) throws ParseException {
        Float f = null;
        if (! StringUtils.isEmpty(string)) {
            Number n = this.decimalFormatter.parse(string);
            //Not sure if this is Float or not, so we convert.
            f = new Float(n.toString());
        }
        return f;
    }

    /**
     * Returns null if string is null or empty.
     */
    public Integer parseStringToInteger(String string) throws ParseException {
        Integer i = null;
        if (! StringUtils.isEmpty(string)) {
            Number n = this.integerFormatter.parse(string);
            //Not sure if this is Integer or not, so we convert.
            i = new Integer(n.toString());
        }
        return i;
    }
    
    /**
     * Formats the number to a String, using no decimal places, according to the
     * current locale. 
     * 
     * If number is null this method returns empty string.
     */
    public String formatInteger(Number number) {
        String s = null;
        if (number != null) {
            s = integerFormatter.format(number);
        }
        else {
            s = "";
        }
        return s;
    }
    
    /**
     * If timezone is not passed in, server (default) time zone is used.
     * 
     * @param pattern
     * @param tz
     * @return
     */
    private DateFormat getDateFormatter(String pattern, TimeZone tz) {
        DateFormat formatter = new SimpleDateFormat(pattern, localeForDates);
        if (tz != null)
            formatter.setTimeZone(tz);
        return formatter;
    }
    
    /**
     * Returns the appropriate String date pattern for the current
     * locale.
     */
    private String getDatePattern(DatePatternType patternType) {
        DatePattern userLocalePattern = patternType.getUserLocalePattern();
        String pattern = userLocale.getPatternString(userLocalePattern);
        return pattern;
    }
    
}