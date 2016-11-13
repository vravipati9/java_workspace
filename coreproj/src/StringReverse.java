import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringReverse {

	public static void main(String[] args) {
		final String str;
		str = "asdf";
		String s = reverseString("Siva");
		try {
			start();
		} catch (IOException e) {
			// TODO: handle exception
		}
		System.out.println(s);
		 countNumOfOccurencesInList();
		try {
			int x = Integer.parseInt("two");
		} catch (IllegalArgumentException iae) {
			System.out.println("IllegalArgumentException");
		}  finally{
			try{
				
			} catch (Exception e) {
				
			}
			finally {
				
			}
		}

	}

	static void start() throws IOException{
		System.out.println("in start method");
		
	}
	
	static String reverseString(String s) {
		System.out.println(s.length());
		char c[] = s.toCharArray();
		char c1[] = new char[s.length()];
		int j = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			c1[j] = c[i];
			j++;
		}

		return String.valueOf(c1);
	}

	static void countNumOfOccurencesInList() {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("one");
		list.add("three");
		list.add("four");
		boolean found = false;
		List<String> anotherList = new ArrayList<String>();
		Map<String, String> map = new HashMap<String, String>();
		String value = "1";
		for (String string : list) {
			if (map.containsKey(string)) {
				String val = map.get(string);
				int i = Integer.parseInt(val);
				i++;
				map.put(string, String.valueOf(i));
			} else {
				map.put(string, value);
			}
		}
		System.out.println(map);

	}
}
