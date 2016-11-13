import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class EqlsHash {

	public static void main(String[] args) {
		Door obj1 = new Door("First" );
		
		Door obj2 = new Door("First" );
		HashSet<Door> hs = new HashSet<Door>();
		hs.add(obj1);
		hs.add(obj2);
		for (Door object : hs) {
			System.out.println(object.hashCode());
		}
		
		HashMap<Door, String> map = new HashMap<Door, String>();
		map.put(obj1, "one");
		map.put(obj2, "two");
		System.out.println("Map Size...."+map.size());
		Set<Door> mapKeys = map.keySet();
		for (Door door : mapKeys) {
			System.out.println(""+door.getName());
		}
		
	}																			
}
