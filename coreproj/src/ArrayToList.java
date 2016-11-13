import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {

	public static void main(String[] args) {
		String sa[] = new String[] {"one" , "two", "three", "four"};
		List<String> toList = Arrays.asList(sa);
		System.out.println(toList);
		System.out.println("Element at 1 "+sa[1]);
		sa[1]= "siva";
		System.out.println(toList.get(1));
		System.out.println("=============Ex of toArray=============");
		List<Integer> intList = new ArrayList<Integer>();
		for (int i=0;i<3;i++) intList.add(i);
		Object[] objArr = new Object[intList.size()];
		Integer[] intArr = new Integer[intList.size()];
		//Long[] longArr = new Long[intList.size()];	// ArrayStoreException if the runtime type of a is not a supertype
	     												// of the runtime type of every element in this list.
		objArr  = intList.toArray(intArr);
		for (Object intObj : intArr) {
			System.out.print(intObj+"	");
		}
		System.out.println("\n"+intArr[1]);
		intArr[1] = 23;
		
		for (Integer integer : intList) {
			System.out.println(integer);
		}
		for (Object intObj : intArr) {
			System.out.print(intObj+"	");
		}
	}

}
