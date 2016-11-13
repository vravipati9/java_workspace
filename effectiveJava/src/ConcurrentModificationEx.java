import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


class ConcurrentModificationEx extends ArrayList<String>{

	private static final long serialVersionUID = -4948829171643028979L;

	public static void main(String[] args) {
		ConcurrentModificationEx obj = new ConcurrentModificationEx();
		ArrayList<String> strs = new ArrayList<String>();
		strs.add("one");
	    strs.add("two");
	    strs.add("three");
	    Iterator<String> it = strs.iterator();
	    while(it.hasNext()) {
	    	String s = it.next();
	        if (s.equalsIgnoreCase("two")) {
	            it.remove();	// correct Implementation to avoid ConcurrentModificationException
	            //strs.remove("one"); // Invalid Implementation
	        }
	    }
	    System.out.println(strs);
	}

	
}
