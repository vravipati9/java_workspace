package chapter2;

import java.util.Calendar;

public class PersonTest {
	public static void main(String a[]) {
		Calendar birthDate = Calendar.getInstance();
		birthDate.set(1949, Calendar.JANUARY, 1);
		
		Person person =  new Person(birthDate.getTime());
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			person.isBabyBoomer_slow_version();
		}
		long totalTime = System.currentTimeMillis() - startTime;
		
		long startTimeWithImprovedMethod = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			person.isBabyBoomer_fast_version();
		}
		long totalTimeWithImprovedMethod = System.currentTimeMillis() - startTimeWithImprovedMethod;
		
		System.out.println("Total Time Taken to execute Person with Slow Version:::"+totalTime);
		System.out.println("Total Time Taken to execute Person with Improved version:::"+totalTimeWithImprovedMethod);
	}
}
