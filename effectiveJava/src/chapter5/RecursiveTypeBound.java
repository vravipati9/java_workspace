package chapter5;
import java.util.*;
public class RecursiveTypeBound {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11, 18, 16, 19);
		Integer max = max(list);
		System.out.println(max);
		
		List<String> listOfStrings = Arrays.asList("d", "c", "a", "A");
		String max1 = max(listOfStrings);
		System.out.println(max1);
		
		
	}
	
	public static <T> Iterable<T> takeWhile(final List<T> ts) {
		return new Iterable<T>() {
			protected final Iterator<T> iter = ts.iterator();
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return false;
					}
					
					@Override
					public T next() {
						// TODO Auto-generated method stub
						return null;
					}
					
					@Override
					public void remove() {
						// TODO Auto-generated method stub
						
					}
					
				};
			}
		};
	}
	
	public static <T extends Comparable<T>> T max(List<T> list) {
		Iterator<T> it = list.iterator();
		T max = it.next();
		while(it.hasNext()) {
			T t = it.next();
			if (max.compareTo(t) < 0) {
				max = t;
			}
		}
		return max;
	}
	
	public static <T extends Comparable<? super T>> T maxWithWildCards(List<? extends T> list) {
		Iterator<? extends T> it = list.iterator();
		T max = it.next();
		while(it.hasNext()) {
			T t = it.next();
			if (max.compareTo(t) < 0) {
				max = t;
			}
		}
		return max;
	}	
}
