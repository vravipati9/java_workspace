import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SearchObjArray {
	public static void main(String a[]) {
		String[] sa = {"one", "two", "three", "four"};
		//Arrays.sort(sa);
		for(String str : sa) {
			System.out.print(str + "  ");
		}
		System.out.println("\nthree	"+Arrays.binarySearch(sa, "three"));
		
		ResortComparator rs = new ResortComparator();
		Arrays.sort(sa, rs);
		for(String str : sa) {
			System.out.print(str + "  ");
		}
		System.out.print("\ntwo	"+Arrays.binarySearch(sa, "two"));
		System.out.print("\ntwo	"+Arrays.binarySearch(sa, "two", rs));
	}
	static class ResortComparator implements Comparator<String> {

		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}
	}
}
