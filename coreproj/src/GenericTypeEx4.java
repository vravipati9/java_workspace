import java.util.ArrayList;
import java.util.List;

public class GenericTypeEx4 {
	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<Integer>(); // (1)
		lst.add(2007);
		lst.add(2008);
		//List<Number> numList = lst; // (2)
		for (Number n : lst)
			// (3)
			System.out.println(n + " ");
	}
}