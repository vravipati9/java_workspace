import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class CollectionFinal {
	static int i;
	public static void main(String[] args) {
		
		final List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		for (String string : list) {
			//System.out.println(string);
		}
		
		//Map<String, String> map = new LinkedHashMap<String, String>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("one", "1");
		map.put("two", "2");
		map.put("", "3");
		map.put("four", "4");
		map.put("five", "5");
		map.put("ten", "10");
		map.put("four", "7");
		map.put(null, null);
		System.out.println("Size>>>"+map.size());
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.println(key  +"  " +map.get(key));
		}
		
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(12);list1.add(121);list1.add(112);list1.add(122);list1.add(212);list1.add(122);list1.add(122);list1.add(312);list1.add(132);list1.add(123);
		list1.add(162);list1.add(125);list1.add(412);list1.add(142);list1.add(124);
		list1.get(20);
		System.out.println(list1.size());
		list1.trimToSize();
		System.out.println(list1.size());
	}

}
