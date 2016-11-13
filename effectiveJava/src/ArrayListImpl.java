import java.util.AbstractList;
import java.util.ArrayList;
public class ArrayListImpl extends AbstractList<String>{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayListImpl arl = new ArrayListImpl();
		arl.add("one");
		arl.add("two");
		arl.add("three");
		arl.add("four");
		arl.add("five");
		arl.add("six");
		arl.add("seven");
		arl.add("eight");
		
		arl.removeRange(1, 3);
	}
	@Override
	public String get(int index) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}
}
