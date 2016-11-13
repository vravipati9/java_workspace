import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class RemoveDupElements {

	public static void main(String[] args) {
		List<Integer> list =  new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(10);
		list.add(10);
		list.add(30);
		Set<Integer> set = new HashSet<Integer>();
		set.addAll(list);
		
		Set<Integer> set1 = new LinkedHashSet<Integer>();
		set1.addAll(list);
		
		
		System.out.println("separatedNumbers   :  "+set);
		System.out.println("separatedNumbers   :  "+set1);
		
	}
}
