package chapter2;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person {
	private final Date birthDate;
	private static final Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	private static final Date startDate;
	private static final Date endDate;
	
	public Person(Date birthDate) {
		// Defensive copy - see Item 39
		System.out.println("constructor block");
		this.birthDate = new Date(birthDate.getTime());
	}
	
	static {
		System.out.println("Static block");
		gmtCal.set(1946, Calendar.JANUARY, 1);
		startDate = gmtCal.getTime();
		
		gmtCal.set(1965, Calendar.JANUARY, 1);
		endDate = gmtCal.getTime();
	}
	// Baby boomer is a person who born between 1946 and 1964
	// Below method un necessarly creates Calendar, TimeZone, Date instances each method is invoked 
	public boolean isBabyBoomer_slow_version() {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		
		gmtCal.set(1946, Calendar.JANUARY, 1);
		Date startDate = gmtCal.getTime();
		
		gmtCal.set(1965, Calendar.JANUARY, 1);
		Date endDate = gmtCal.getTime();
		
		return birthDate.compareTo(startDate) >= 0 &&
		birthDate.compareTo(endDate) < 0;
	}
	// Improved code
	public boolean isBabyBoomer_fast_version() {
		
		return birthDate.compareTo(startDate) >= 0 &&
			birthDate.compareTo(endDate) < 0;
	}
}
