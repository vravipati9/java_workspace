package chapter4;

import java.util.Arrays;

class FunctionObjectsForStrategy {
	public static void main(String... a) {
		String[] strArray = new String[]{"ravipat", "siva"};

		Arrays.sort(strArray, StringLengthComparator.INSTANCE);
		System.out.println(Arrays.toString(strArray));

		Arrays.sort(strArray, new StringLengthComparator() {  
			public int compare(String s1, String s2) {  
				return s1.length() - s2.length();  
			}  
		});  
		TestNestedClass t = new TestNestedClass();
		/*
		 * Convert Arrays to String format, Convert Array to String
		 * Arrays.deepToString(arr) for arrays within arrays
		 */
		System.out.println("Another Way:::"+Arrays.toString(strArray));

	}
}



