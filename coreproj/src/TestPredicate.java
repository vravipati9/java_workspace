import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPredicate {
	
	public static void main(String a[]) {
/*		Predicate predicate = new EvenNumPredicate();
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(14);
		list.add(15);
		list.add(13);
		for (Integer integer : list) {
			if (predicate.evaluate(integer)) {
				
			}
		}
		
		*/
		int[] i ;
		i = new int[1];
		i[0] = 12;
		
		int[] j = new int[] {12};
		
		int[] k = {12, 11};
		
		boolean flag = Arrays.equals(i, j);
		System.out.println(flag);
		
		int arrayOne [][] = new int[3][];
		int arrayTwo [][] = new int[3][];
		
				
		arrayOne[0] = i;
		arrayOne[1] = j;
		
		System.out.println("Multidimensional>>>"+Arrays.equals(arrayOne, arrayTwo));
		System.out.println("Multidimensional>>>"+Arrays.deepEquals(arrayOne, arrayTwo));
		
        Object[] o1 = new Object[]{"one", new String[]{"two"}};
        Object[] o2 = new Object[]{"one", new String[]{"two"}};
	      
	    System.out.println("Object array o1: " + Arrays.toString(o1) + " and o2: "+ Arrays.toString(o2));
	    System.out.println("Comparing Object Array o1 and o2 with Arrays.equals : "+ Arrays.equals(o1, o2));	                            
	    System.out.println("Comparing Object Array o1 and o2 with Arrays.deepEquals : "+ Arrays.deepEquals(o1, o2));
	                            
		System.out.println("Done.........");
		
	}
}
