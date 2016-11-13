import java.util.*;

public class SubListEx {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");list.add("B");list.add("C");list.add("D");list.add("E");list.add("F");
		List<String> subList = list.subList(1, 4);
		System.out.println("SubList:::"+subList);
	}
}
