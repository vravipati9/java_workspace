import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class HashtableHashMap {

	public static void main(String[] args) {
		Map<String, String> ht = new Hashtable<String, String>();
		//ht.put(null, "");	not allowed, In Hashtable we can't store null as key
		//ht.put("", null); not allowed, In Hashtable we can't store null as value
		System.out.println(ht);
		
		Map<String, String> hm = new HashMap<String, String>();
		hm.put(null, "  ");	
		hm.put("", null);
		System.out.println(hm);
		
		Collection<String> values = hm.values();
		for (String string : values) {
			System.out.println(string);
		}
		
		Set<String> keySet = hm.keySet();
		for (String string : keySet) {
			System.out.println(hm.get(string));
			//hm.put("2", "s"); // can't modify any thing
		}
		Set<Entry<String,String>> entrySet = hm.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey()+"--"+entry.getValue());
		}
		
		Map<Integer, String> cache = new HashMap<Integer, String>(); 
		cache.put(1, "Stuart"); 
		cache.put(2, "Steven"); 
		cache.put(3, "James"); 
		cache.put(4, "Ian");

		Map<Integer, String> copy = new LinkedHashMap<Integer, String>(cache); 
		System.out.println("Order of Entries in a copy Map created by LinkedHashMap");
		System.out.println(copy);
		System.out.println(cache);	
		int a = 133;
		Integer b = new Integer(133); 
		System.out.println(b.equals(a));	
		
	}
}



