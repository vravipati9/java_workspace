import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObjectSort {

	public static void main(String[] args) {
		List<DVDInfo> list = new ArrayList<DVDInfo>();
		List<String> list1 = new ArrayList<String>();
		populateList(list);
		System.out.println(list.size());
		Collections.sort(list);
		System.out.println(list);
	}

	private static void populateList(List<DVDInfo> list) {
		DVDInfo obj1 = new DVDInfo("SINGAM", "ACTION", "AJAYDEVGAN");
		DVDInfo obj2 = new DVDInfo("RAVAN", "FICTION", "SHARUKH");
		DVDInfo obj3 = new DVDInfo("DOSTANA", "COMEDY", "ABHISHEK");
		list.add(obj1);list.add(obj2);list.add(obj3);
	}
	
}
