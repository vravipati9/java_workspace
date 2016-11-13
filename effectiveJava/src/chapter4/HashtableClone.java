package chapter4;

import java.util.Iterator;
import java.util.Map;



public class HashtableClone<K,V> {
	private Entry[] bucket;
	private int capacity = 0;
	public HashtableClone() {
		this.bucket = new Entry[10];
	}
	private class Entry<K,V> {
		private K key;
		private V value;
		private Entry next;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		public String toString() {
		    return key.toString()+"="+value.toString();
		}
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}
	}
	
	public synchronized Object put(Object key, Object value) {
		Entry entry = new Entry(key, value);
		bucket[capacity++] = entry;
		System.out.println(bucket);
		return key;
	}
    public synchronized String toString() {
    	int max = bucket.length - 1;
    	if (max == -1)
    	    return "{}";

    	StringBuilder sb = new StringBuilder();
    	sb.append('{');
    	for (int i = 0; i < capacity; i++) {
			Entry e = bucket[i];
			Object key = e.getKey();
			Object value = e.getValue();
            sb.append(key.toString());
    	    sb.append('=');
    	    sb.append(value.toString());
    	    sb.append(", ");
		}
    	sb.append('}');
    	return sb.toString();
     }
    
	public static void main(String a[]) {
		HashtableClone<String, String> obj = new HashtableClone<String, String>();
		obj.put("one", "1");
		System.out.println(obj);
		
		HashtableClone<String, Integer> obj1 = new HashtableClone<String, Integer>();
		obj1.put("wss", 1);
		System.out.println(obj1);
		
	}
}
