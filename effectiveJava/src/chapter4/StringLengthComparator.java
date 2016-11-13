package chapter4;

import java.io.Serializable;
import java.util.Comparator;

class StringLengthComparator implements Comparator<String>, Serializable {
	public static final StringLengthComparator INSTANCE = new StringLengthComparator();
	
	//private StringLengthComparator() {
	//}

	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
}

class TestNestedClass {}