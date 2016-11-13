import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] charArray = { 's', 'i', 'v', 'a' };
		System.out.println(charArray.length);
		String str = charArray.toString();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < charArray.length; i++) {
			sb.append(charArray[i]);
		}
		System.out.println(sb);

		Map<String, String> map = new HashMap<String, String>();
		map.put("3", "three");
		map.put("1", "one");
		map.put("4", "four");
		map.put("2", "two");
		// Set keySet = map.keySet();
		// Set entrySetObj = map.entrySet();
		// for (Object s : entrySetObj) {
		// System.out.println(s);
		// }
		// Object[] objArray = keySet.toArray();
		// Arrays.sort(objArray);
		// for(Object o : objArray) {
		// System.out.print(map.get(o)+"   ");
		// }
		Iterator iterator = map.entrySet().iterator();

		for (Map.Entry entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : "
					+ entry.getValue());
		}

		System.out.println("Sorted Map......");
		Map<String, String> sortedMap = sortByComparator(map);

		for (Map.Entry entry : sortedMap.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : "
					+ entry.getValue());
		}
	}

	private static Map sortByComparator(Map unsortMap) {

		List list = new LinkedList(unsortMap.entrySet());

		// sort list based on comparator
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
						.compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		// put sorted list into map again
		Map sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

}
