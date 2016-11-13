import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BackedCollections {
	public static void main(String a[]) {
		System.out.println("***************8");
		Map<String, String> mapex = new HashMap<String, String>();
		mapex.put("1", "one");
		mapex.put("2", "two");
		mapex.put("3", "three");
		Set<String> kSet = mapex.keySet();

		kSet.remove("1");
		System.out.println(mapex.size());
	}
}
