import java.util.TreeSet;

public class TreeSetEx {
	public static void main(String[] args) {
		TreeSet<String> s = new TreeSet<String>();
		TreeSet<String> subs = new TreeSet<String>();
		s.add("a");
		s.add("b");
		//s.add("c");
		s.add("d");
		s.add("e");

		subs = (TreeSet) s.subSet("b", true, "z", true);
		s.add("g");
		System.out.println(s);
		System.out.println(subs);
		s.pollFirst();
		System.out.println("pollFirst>>>>"+s);
		s.pollFirst();
		System.out.println("pollFirst>>>>"+s);
		s.add("c2");
		System.out.println("	"+s);
		subs.add("s");
		System.out.println("Adding C	"+subs);
		System.out.println("Adding C	"+s);
		System.out.println(s.size() + " " + subs.size());
		
		System.out.println("TailSet		"+s.tailSet("d"));
		
		//System.out.println("TailSet		"+s.tailSet("d", true));
	}

}
