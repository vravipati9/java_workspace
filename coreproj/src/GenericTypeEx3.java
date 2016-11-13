import java.util.ArrayList;
import java.util.List;

public class GenericTypeEx3 {
	public static void main(String[] args) {
		List<Integer> glst1 = new ArrayList<Integer>(); // (1)
		List nglst1 = glst1; // (2)
		List nglst2 = nglst1; // (3)
		List<Integer> glst2 = glst1; // (4)
		System.out.println("Compiled");
		mOne(glst1);
		System.out.println(glst1);
	}
	
	static void mOne(List list) {
		list.add(new Object());
	}
}