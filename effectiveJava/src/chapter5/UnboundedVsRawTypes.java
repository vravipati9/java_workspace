package chapter5;
import java.util.*;
public class UnboundedVsRawTypes {

	public static void main(String[] args) {
		List<String> listOfStrings = new ArrayList<String>();
		unsafeAdd(listOfStrings);
		
		
	}
	
	private static void unsafeAdd(List list) {
		list.add("");
		list.add(1);
	}
	
	private static void safeAdd(List<?> list) {
		if (list instanceof List) {
			//allowed
		}
		if (list instanceof List<?>) {
			//allowed
		}
		//list.add("");
		//list.add(1);
		list.add(null);		//not allowed to add any thing other than null
		
	}
	
}
