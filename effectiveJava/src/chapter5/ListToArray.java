package chapter5;

import java.util.*;

public class ListToArray {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");list.add("B");list.add("A");list.add("B");
		String[] s = new String[0];
		s = list.toArray(s);
		System.out.println(Arrays.toString(s));
		
		//List<String>[] stringLists = new List<String>[1]; // Not allowed
		List<String>[] stringLists = new List[1]; // (1)
		List<Integer> intList = Arrays.asList(42); // (2)
		Object[] objects = stringLists; // (3)
		objects[0] = intList; // (4)
		String s1 = stringLists[0].get(0);		// Generates ClassCastException
		System.out.println(s1);	
	}

/*	public <T> T[] toArray(T[] a) {
		if (a.length < size)
			return (T[]) Arrays.copyOf(elements, size, a.getClass());
		System.arraycopy(elements, 0, a, 0, size);
		if (a.length > size)
			a[size] = null;
		return a;
	}
*/}
