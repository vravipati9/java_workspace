package chapter3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class EqualityTest {
	public static void main(String ... s) {
		Collection<Foo> items = new ArrayList<Foo>();
		Foo i = new Foo();
        items.add(i);
        System.out.println(items.contains(i));   // Prints true!
	}
}

// Test 2 sets equal
class Foo {
	int i;

	public boolean equals11(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Foo other = (Foo) obj;
		if (i != other.i)
			return false;
		return true;
	}

}

