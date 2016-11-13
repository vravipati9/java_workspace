import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class UnSupportedOperationEx {

	public static void main(String[] args) {
		//Pass java.util.Arrays.ArrayList
		// Pass java.util.ArrayList
		List<String> list = new ArrayList<String>(Arrays.asList(""));
		System.out.println(list);
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			String s = (String) it.next();
			if (s.length() == 0)
				it.remove();
		}
		
		System.out.println(list);
		removeZeroLengthStringsFrom(Arrays.asList(""));
		
	}

	static void removeZeroLengthStringsFrom(List<String> stringList)
	{
		ListIterator<String> iter = stringList.listIterator();
		String s;
		while (iter.hasNext())
		{
			s = iter.next();
			if (s.length() == 0)
			{
				iter.remove();
			}
		}
	}
}
/*
I think you may be using the Arrays utility to get the List that you pass into that method. 
The object is indeed of type ArrayList, but it's java.util.Arrays.ArrayList, not java.util.ArrayList.

The java.util.Arrays.ArrayList version is immutable and its remove() method is not overridden. 
As such, it defers to the AbstractList implementation of remove(), which throws an UnsupportedOperationException.
*/