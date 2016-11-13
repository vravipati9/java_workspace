package chapter4;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class InstrumentedSetCompTest {

	public static void main(String[] args) {
		
		Set<Date> s = new InstrumentedSetComp<Date>(new TreeSet<Date>());
		Set<String> s2 = new InstrumentedSetComp<String>(new HashSet<String>());
		
/*		s.addAll(Arrays.asList(new Date(), new Date(), new Date()));
		System.out.println("Size:::"+s.size());
		System.out.println(s);*/
		
		s2.addAll(Arrays.asList("One", "four", "three"));
		System.out.println("Size:::"+s2.size());
	}
}
