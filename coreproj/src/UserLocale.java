import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * This class represents Locale information about a CrossroadsUser. It contains
 * the java.util.Locale object for the user and date pattern strings for
 * all the date patterns used in the Crossroads system.
 */
public class UserLocale implements Serializable
{

    private static final long serialVersionUID = 6979717383619986568L;

    private Integer id = null;
    private String userLocaleName = null;
    private String countryCode = null;
    private String languageCode = null;
    private String mediumWith24HourTimePattern = null;
    private String shortPattern = null;
    private String shortFullYearPattern = null;
    private String mediumShortYearPattern = null;
    private String mediumPattern = null;
    private String mediumWithDayOfWeekPattern = null;
    private String rawPattern = null;
    private String fullPattern = null;
    private String twelveHourTimePattern = null;
    private String twentyFourHourTimePattern = null;

    private Locale locale = null;
    private Map<DatePattern, String> patternMap = null;
    
    public enum DatePattern {
        MEDIUM_W_24_HR_TIME,
        SHORT,
        SHORT_FULL_YEAR,
        MEDIUM_SHORT_YEAR,
        MEDIUM,
        MEDIUM_W_DOW,
        RAW,
        FULL,
        TWELVE_HOUR_TIME,
        TWENTYFOUR_HOUR_TIME
    }
    
    public UserLocale()
    {
        
    }
    
    public Locale getLocale()
    {
        if (locale == null) {
            if (countryCode != null && languageCode != null) {
                locale = new Locale(languageCode, countryCode);
            }
        }
        return locale;
    }
    
    /**
     * Returns a pattern String for this UserLocale based on the 
     * DatePattern enum type passed in. 
     * 
     * getPatternString(DatePattern.MEDIUM) is equivalent to 
     * getMediumPattern().
     *  
     */
    public String getPatternString(DatePattern pattern) {
        //We may need to initialize the pattern map.
        if (patternMap == null) {
            buildPatternMapIfMapNull();
        }
        return patternMap.get(pattern);
    }
     

    /**
     * Builds a Map of all date patterns for this UserLocale.
     */
    private void buildPatternMap()
    {
        this.patternMap = new HashMap<DatePattern, String>();
        this.patternMap.put(DatePattern.FULL, getFullPattern());
        this.patternMap.put(DatePattern.MEDIUM, getMediumPattern());
        this.patternMap.put(DatePattern.MEDIUM_SHORT_YEAR, getMediumShortYearPattern());
        this.patternMap.put(DatePattern.MEDIUM_W_24_HR_TIME, getMediumWith24HourTimePattern());
        this.patternMap.put(DatePattern.MEDIUM_W_DOW, getMediumWithDayOfWeekPattern());
        this.patternMap.put(DatePattern.RAW, getRawPattern());
        this.patternMap.put(DatePattern.SHORT, getShortPattern());
        this.patternMap.put(DatePattern.SHORT_FULL_YEAR, getShortFullYearPattern());
        this.patternMap.put(DatePattern.TWELVE_HOUR_TIME, getTwelveHourTimePattern());
        this.patternMap.put(DatePattern.TWENTYFOUR_HOUR_TIME, getTwentyFourHourTimePattern());
    }
    
    /**
     * This synchronzied method should be called to build the pattern map.
     * It will prevent multi-threading issues (as unlikely as those are).
     */
    private synchronized void buildPatternMapIfMapNull() {
        if (this.patternMap == null) {
            buildPatternMap();
        }
    }
    
    public String getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }

    public String getFullPattern()
    {
        return fullPattern;
    }

    public void setFullPattern(String fullPattern)
    {
        this.fullPattern = fullPattern;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getLanguageCode()
    {
        return languageCode;
    }

    public void setLanguageCode(String languageCode)
    {
        this.languageCode = languageCode;
    }

    public String getMediumPattern()
    {
        return mediumPattern;
    }

    public void setMediumPattern(String mediumPattern)
    {
        this.mediumPattern = mediumPattern;
    }

    public String getMediumShortYearPattern()
    {
        return mediumShortYearPattern;
    }

    public void setMediumShortYearPattern(String mediumShortYearPattern)
    {
        this.mediumShortYearPattern = mediumShortYearPattern;
    }

    public String getMediumWith24HourTimePattern()
    {
        return mediumWith24HourTimePattern;
    }

    public void setMediumWith24HourTimePattern(String mediumWith24HourTimePattern)
    {
        this.mediumWith24HourTimePattern = mediumWith24HourTimePattern;
    }

    public String getMediumWithDayOfWeekPattern()
    {
        return mediumWithDayOfWeekPattern;
    }

    public void setMediumWithDayOfWeekPattern(String mediumWithDayOfWeekPattern)
    {
        this.mediumWithDayOfWeekPattern = mediumWithDayOfWeekPattern;
    }

    public String getUserLocaleName()
    {
        return userLocaleName;
    }

    public void setUserLocaleName(String name)
    {
        this.userLocaleName = name;
    }

    public String getRawPattern()
    {
        return rawPattern;
    }

    public void setRawPattern(String rawPattern)
    {
        this.rawPattern = rawPattern;
    }

    public String getShortFullYearPattern()
    {
        return shortFullYearPattern;
    }

    public void setShortFullYearPattern(String shortFullYearPattern)
    {
        this.shortFullYearPattern = shortFullYearPattern;
    }

    public String getShortPattern()
    {
        return shortPattern;
    }

    public void setShortPattern(String shortPattern)
    {
        this.shortPattern = shortPattern;
    }

    public String getTwelveHourTimePattern()
    {
        return twelveHourTimePattern;
    }

    public void setTwelveHourTimePattern(String twelveHourTimePattern)
    {
        this.twelveHourTimePattern = twelveHourTimePattern;
    }

    public String getTwentyFourHourTimePattern()
    {
        return twentyFourHourTimePattern;
    }

    public void setTwentyFourHourTimePattern(String twentyFourHourTimePattern)
    {
        this.twentyFourHourTimePattern = twentyFourHourTimePattern;
    }
    
}