package chapter4;
import java.util.*;
//Concrete implementation built atop skeletal implementation - Page 95
public class ConcreteImplForSkeletalInterface {

	public static void main(String[] args) {
		int a[] = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		List<Integer> list = intArrayAsList(a);
		a[5] = 12;
		System.out.println(list);
		//list.get(0);
	}
	
	static List<Integer> intArrayAsList(final int[] a) {
		if (a == null) {
			throw new NullPointerException();
		}
		return new AbstractList<Integer>() {

			@Override
			public Integer get(int index) {
				return a[index];
			}

			@Override
			public int size() {
				return a.length;
			}
			
			@Override
			public Integer set(int index, Integer element) {
				int oldVal = a[index];
				a[index] = element;
				return oldVal;
			}
		};
		
		
		//return new AbsList(a);
	}
}

class AbsList extends AbstractList<Integer> {

	int a[] ;
	AbsList(int[] array) {
		a = array;
	}
	
	@Override
	public Integer get(int index) {
		System.out.println("GET CALLED");
		return a[index];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return a.length;
	}
	@Override
	public Integer set(int index, Integer element) {
		System.out.println("SET CALLED");
		int oldVal = a[index];
		a[index] = element;
		return oldVal;
	}
}

