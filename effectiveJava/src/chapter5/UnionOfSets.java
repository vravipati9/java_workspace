package chapter5;
import java.io.Serializable;
import java.util.*;
public class UnionOfSets {

	public static void main(String[] args) {
		Set<String> guys = new HashSet<String>(Arrays.asList("Tom", "Dick", "Harry"));
		Set<String> stooges = new HashSet<String>(Arrays.asList("Larry", "Moe", "Curly"));
		Set<String> aflCio = union(guys, stooges);
		System.out.println(aflCio);
		
		Serializable s = pick("d", new ArrayList<Integer>());
		
		Set<Integer> intSet = new HashSet<Integer>(Arrays.asList(12, 33, 11));
		Set<Double> doubleSet = new HashSet<Double>(Arrays.asList(12.1, 33.3, 11.2));
		Set<Number> numberSet = UnionOfSets.<Number>unionWithWildCards(intSet, doubleSet);
		
	}	
	

	private static <E> Set<E> union(Set<E> set1, Set<E> set2) {
		Set<E> result = new HashSet<E>(set1);
		result.addAll(set2);
		return result;
	}

	private static <E> Set<E> unionWithWildCards(Set<? extends E> set1, Set<? extends E> set2) {
		Set<E> result = new HashSet<E>(set1);
		result.addAll(set2);
		return result;
	}

	static <T> T pick(T a1, T a2) {
		System.out.println("pick method called");
		List l = (List)a2;
		l.add("");
		return a2;
	}
}
