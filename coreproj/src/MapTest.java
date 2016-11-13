import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Map hashMap = new HashMap<String, String>();
		Map hashTable = new Hashtable<String, String>();
		Set<String> hashSet = new HashSet<String>();
		
		enterElements(hashMap);
		System.out.println("ELEMENTS IN HASHMAP	::"+hashMap.size());
		displayElements(hashMap);
		
		//enterElements(hashTable);
		//System.out.println("\nELEMENTS IN HASHTABLE	::"+hashTable.size());
		//displayElements(hashTable);
		
	
		
	}
	private static void enterElements(Map<String, String> map) {
		System.out.println("<<In enter elements>>");
		map.put("1", "one");	map.put("3", "three");
		map.put("2", "two");	map.put("", "four");
		map.put(null, "NULL"); map.put(null, "NULL1");
		String s = map.put("2", "twotwo");	
		System.out.println("Return value for already Inserted element:::"+s+"    "+map.get("2"));
		
		Set<String> set = new HashSet<String>();
		boolean b1 = set.add("One");
		boolean b2 = set.add("One");
		System.out.println("First Element in Set added::"+b1+"    Second element in Set added::"+b2);
		
		Map<Integer, Boolean> map2 = new HashMap<Integer, Boolean>();
		
	}
	
	private static void displayElements(Map<String, String> map) {
		Set<String> keySet = map.keySet();
		System.out.println(map.getClass().getName()+" "+keySet.size());
		for (String str : keySet) {
			System.out.print(str+" - "+map.get(str)+" , ");
		}
		Set<Entry<String, String>> keyValSet = map.entrySet();
		for (Entry<String, String> entry : keyValSet) {
			
		}
		
		System.out.println("Key Value Set>>>"+keyValSet);
	}

}
