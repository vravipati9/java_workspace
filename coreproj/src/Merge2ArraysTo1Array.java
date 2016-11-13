import java.util.Arrays;
import java.util.Scanner;


public class Merge2ArraysTo1Array {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int _a_cnt = 0;
		int[] _a = new int[100001];
		int[] _b = new int[200002];

		try {
			_a_cnt = sc.nextInt();
		}catch (Exception e) {
			System.out.println("Here: " + e.getMessage()); 
		} 

		for( int i = 0;i < _a_cnt;i++ ){			_a[i] = sc.nextInt();		
		}
		for( int i = 0;i < _a_cnt;i++ ){
			_b[i] = sc.nextInt();		
		}	

		_b = mergeArray(_a ,_b, _a_cnt);
		for( int i = 0;i < 2 * _a_cnt;i++ ){
			System.out.print(_b[i] + " ");		
		}
	}
	static int[] mergeArray(int []a, int []b, int M ){

		 int j = 0, k = 0;
		int c [] = new int[a.length+b.length];//10 values

	    // we're filling c with the next appropriate number
	    // we start with checking a[0] and b[0] till we add
	    // all the elements
	    for (int i = 0; i < c.length; i++) {
	        // if both "a" and "b" have elements left to check
	        if (j < a.length && k < b.length) {
	            // check if "b" has a smaller element
	            if (b[k] < a[j]) {
	                // if so add it to "c"
	                c[i] = b[k];
	                k++;
	            }
	            // if "a" has a smaller element
	            else {
	                // add it to "c"
	                c[i] = a[j];
	                j++;
	            }       
	        }
	        // if there are no more elements to check in "a"
	        // but there are still elements to check in "b"
	        else if (k < b.length) {
	            // add those elements in "b" to "c"
	            c[i] = b[k];
	            k++;
	        }
	        // if there are no more elements to check in "b"
	        // but there are still elements to check in "a"
	        else {
	            // add those elements in "a" to "c"
	            c[i] = a[j];
	            j++;
	        }
	    }
//	   b = Arrays.copyOf(b, b.length * 2);
	    for(int i = 0; i < c.length; i++) {
	    	System.out.println(c[i]);
	    }
	    return c;
	    
	}
	
}
