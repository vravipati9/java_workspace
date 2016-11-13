import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ArrayLt {

	public static void main(String[] args) {
		Map hm = new HashMap();
		Map ht = new Hashtable();
		hm.put("5", "five");
		hm.put("2", "two");
		hm.put("1", "one");
		hm.put("4", "four");
		hm.put("3", "three");
		Set set = hm.keySet();
		Set set1 = hm.entrySet();
		System.out.println(hm);
		ArrayList al = new ArrayList(-1);
		System.out.println(set1);
		for (Object str : set) {
			System.out.println(str);
		}
		
		java.util.List<String> l = new ArrayList<String>();
		addElements(l);
		System.out.println("....."+l);
	}
	public static void addElements(java.util.List l) {
		l.add(1);
	}

}
