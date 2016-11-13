import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;



public class SetToArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> set = new TreeSet<String>();

	    set.add("b");
	    set.add("c");
	    set.add("a");

	    Iterator it = set.iterator();
	    while (it.hasNext()) {
	      Object element = it.next();
	      System.out.println(element);
	    }

	    // Create an array containing the elements in a set
	    String[] array = (String[]) set.toArray(new String[set.size()]);
	    Arrays.toString(array);
	    Arrays.sort(array, Collections.reverseOrder());
	    List<String> myList = new ArrayList<String>(Collections.EMPTY_LIST);
	    myList.add("one");myList.add("two");
	    
	    System.out.println("NewList   :"+myList);
	    List sortedArray = Arrays.asList(array);
	    System.out.println("Sorted Array   :"+sortedArray);
	    String[] mybuff = (String[])set.toArray();
	    System.out.println("  "+mybuff.length);
	}

}
