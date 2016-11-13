import java.util.ArrayList;
import java.util.List;

public class ArrayLt1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(10);
		String s = null;
		list.add("one");
		list.add(0, "five");
		//list.add(3, "three");
		list.add("last");
		list.add(s);
		System.out.println(list.size());
		System.out.println(list);
	}

}
