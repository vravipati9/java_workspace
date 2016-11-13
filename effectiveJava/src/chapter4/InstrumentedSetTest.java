package chapter4;

import java.util.Arrays;

public class InstrumentedSetTest {

	public static void main(String[] args) {
		InstrumentedHashSet<Object> hashSetImpl = new InstrumentedHashSet<Object>();
		hashSetImpl.addAll(Arrays.asList("Lemon", "Orange", "Citrus"));
		System.out.println("Count:::"+hashSetImpl.getCount());
	}

}
