package chapter5;
import java.util.*;
/*
 * 	It had to be legal to pass instances of parameterized types to methods that were designed for
	use with ordinary types, and vice versa. This requirement, known as migration
	compatibility, drove the decision to support raw types.
 */
public class GenericMigrationCompatability {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		List l1 = new ArrayList();
		test(l);
		test(l1);

	}
 	
	static void test(List list) {
		list.add(12);
	}
	
	static void test1(List<String> list) {
		list.add("");
	}

}
