import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * Can your write a function that will replace all tokens delimited by @ with a given String?
           Sample Input = “Hello @name@, where are you @name@?”
 */
/*
 * Write a program that allows you to create an integer array of 5 elements with the following
 * values: int numbers[ ]={5,2,4,3,1}. The program computes the sum of first 5 elements and stores
 * them at element 6, computes the average and stores it at element 7 and identifies the smallest
 * value from the array and stores it at element 8
 */
public class StringReplace {
	public static void main(String[] args) {
		System.out.println(replaceStrings());

	}
	static String replaceStrings() {
		String orignalStr = "Hello @name@, where are you @name@?";
		StringTokenizer st = new StringTokenizer(orignalStr);
		//String[] arr = new String[st.countTokens()];
		List<String> str = new ArrayList<String>();
		while(st.hasMoreElements()) {
			String token = (String)st.nextElement();
			System.out.println(token);
			if(token.startsWith("@")) {
				str.add("Jami");
				
			} else {
				str.add(token);
			}
		}
		StringBuffer sb = new StringBuffer();
		
		for (String string : str) {
			sb.append(string);
		}
		return sb.toString();
	}
}
