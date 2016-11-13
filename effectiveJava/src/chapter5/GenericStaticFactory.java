package chapter5;
import java.util.*;
public class GenericStaticFactory {

	public static void main(String[] args) {
		Map<String, List<String>> map = getHashMap();
	}
	
	static <K, V> HashMap<K, V> getHashMap() {
		return new HashMap<K, V>();
	}
	
	static HashMap getHashMap1() {
		return new HashMap();
	}
}
