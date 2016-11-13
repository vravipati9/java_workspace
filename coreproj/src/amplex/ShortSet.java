package amplex;

import java.util.*;

public class ShortSet {

	public static void main(String[] args) {
		Set<Short> set = new HashSet<Short>();
		for (short i = 0; i < 100; i++) {
			set.add(i);
			set.remove((short) (i-1));
		}
		System.out.println(set.size());
	}

}
