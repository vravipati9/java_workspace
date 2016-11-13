import java.util.ArrayList;
import java.util.List;

public class TypeSafeEx {
	public static void main(String a[]) {
		List<String> l1 = new ArrayList<String>();
		l1.add("one");
		l1.add("two");
		l1.add("three");
		List<String> l2 = new ArrayList<String>();
		l2.add("1");
		l2.add("2");
		l2.add("3");
		List<String> l3 = new ArrayList<String>();
		l3.add("ONE");
		System.out.println("l3Size..."+l3.size());
		System.out.println("l3Size..."+l3.get(0));

		List<Integer> l4 = new ArrayList<Integer>();
		l4.add(Integer.valueOf(12));l4.add(Integer.valueOf(32));
		System.out.println("Integer Val..."+l4);

		//mOne(l1,l2);
		for (int i=0; i<l1.size(); i++) {
			for(int j=0; j<l2.size(); j++) {
				if(i==j){
					System.out.println("---"+l1.get(i)+"---"+l2.get(i));	
				}
			}
		}
		System.out.println("Another for loop...");
		int min = Math.min(l1.size(), l2.size());
		System.out.println("size of both lists...");
		for(int i = 0; i<min; i++) {   
			System.out.println("Formatted for loop---"+l1.get(i)+"---"+l2.get(i));   
		}
		int i=0;int j=0;
		for (String s1 : l1) {
			j=0;
			String temp = s1;
			for (String s2 : l2) {
				String temp1 = s2;
				if (i==j) {
					System.out.println("---"+temp+"---"+temp1);
				}
				j++;
			}

		}

		for (Object element : l1) {
			String obj = (String) element;

		}


	}
	static void mOne(List<String> str1, List<String> str2) {
		for (String s : str1) {

		}
		for (Object element : str1) {

		}
	}
}
