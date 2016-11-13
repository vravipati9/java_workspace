import java.util.*;

class Lien implements Comparable {
	int size;
	Lien(int s) {
		size = s;
	}
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class TreeSet3 {
	public static void main(String[] args) {
		TreeSet<Integer> i = new TreeSet<Integer>();
		TreeSet<Lien> d = new TreeSet<Lien>();
		boolean b1 = d.add(new Lien(1));
		boolean b2 = d.add(new Lien(2));
		boolean b3 = d.add(new Lien(1));
		System.out.println(b1+"   "+b2+"   "+b3);
		i.add(1);
		i.add(2);
		i.add(1);
		System.out.println("Elements in i::"+i);
		System.out.println(d.size() + " " + i.size());
		System.out.println("-------------------");
		String[] colors = {"blue", "red", "green", "yellow", "orange"};
		Arrays.sort(colors);
		int s2 = Arrays.binarySearch(colors, "orange");
		int s3 = Arrays.binarySearch(colors, "violet");
		System.out.println(s2 + " " + s3);
	}
}