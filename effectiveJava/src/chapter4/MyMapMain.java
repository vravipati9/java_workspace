package chapter4;


import java.util.AbstractMap;
import java.util.Set;

public class MyMapMain {
	public static void main(String a[]) {
		MyMap obj = new MyMap();
		MyMap.Entry entry = obj.new Entry<Integer, Integer>(1, 2);
		//obj.put(1, "one");
		
		//MyMap.Entry1<String, String> e1 = obj.Entry1<String, String>("", "");		// will not compile
		MyMap.Entry1<String, String> n = new MyMap.Entry1<String, String>("", ""); // both class names
		
		
	}
}
class MyMap {
	
	public MyMap() {
		System.out.println("Outside constructor");
	}
	Entry<?, ?>[] table = new Entry<?, ?>[3];
	int i = 0;
	public <K, V> void put(K key, V value) {
		Entry<K, V> e = new Entry<K, V>(key, value);
		table[i] = e;
		i++;
	}
	
	public class Entry<K, V> {	// If we declare private, it won't be visible to MyMapMain
		K key;
		V value;
		public Entry(K key, V value) {
			super();
			System.out.println("constructor called for inner class"+i);
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
	}
	
	public static class Entry1<K, V> {	// If we declare private, it won't be visible to MyMapMain
		K key;
		V value;
		public Entry1(K key, V value) {
			super();
			System.out.println("constructor called for inner class");	//static class won't access members of enclosing class
			this.key = key;
			this.value = value;
		}
	}
	
	public static class Entry2{	// If we declare private, it won't be visible to MyMapMain
		String key;
		String value;
		public Entry2(String key, String value) {
			super();
			System.out.println("constructor called for inner class");	//static class won't access members of enclosing class
			this.key = key;
			this.value = value;
		}
	}
}
