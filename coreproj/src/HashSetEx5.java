import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetEx5 {
	String name;
	public HashSetEx5(String str) {
		this.name = str;
	}
	
	public static void main(String a[]) {
		System.out.println("\"siva\" \"rama\" \"krishna\"");
		Set s = new HashSet<Object>();
		boolean add1 = s.add(new Friend("one", "22"));
		System.out.println("1st parameter added:::"+add1);
		boolean add2 = s.add(new Friend("one", "23"));
		System.out.println("2st parameter added:::"+add2);
		
		s.add("one");
		
		System.out.println(s.size());

		//List<Object> myList = new ArrayList<JButton>();
		List<String> l = new ArrayList<String>();
		l.add("1");l.add("2");l.add("3");
		System.out.println(l);
		Collections.reverse(l);
		System.out.println(l);
		java.util.Collections.sort(l);
		System.out.println(l);
	}
}

