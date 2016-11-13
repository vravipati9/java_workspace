import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTypeEx1 {
	public static void main(String[] args) {
		List<?> list = new ArrayList<Integer>();
		list = mOne(list);
		Integer i = (Integer)list.get(0);
		/*		System.out.println(list);
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Integer i = (Integer)it.next();
			System.out.println(i);
		}*/
	}
	
	static List mOne(List list) {
		list.add("safasfd");
		return list;
	}
}