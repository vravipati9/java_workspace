import java.util.*;

public class TreeSetEx4 {

	public static void main(String[] args) {

		TreeSet<Integer> s = new TreeSet<Integer>();

		TreeSet<Integer> subs = new TreeSet<Integer>();

		for (int i = 606; i < 613; i++)

			if (i % 2 == 0)
				s.add(i);

		subs = (TreeSet) s.subSet(608, true, 611, true);

		subs.add(609);

		System.out.println(s + " " + subs);
		
		String[] str = {"abc", "def", "ghi"};
		List<String> listStr = Arrays.asList(str);
		System.out.println(listStr);
		str[0] = "siva";
		System.out.println(listStr);

	}

}
