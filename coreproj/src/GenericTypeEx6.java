import java.util.ArrayList;
import java.util.List;

public class GenericTypeEx6 {
	public static void main(String a[]) {
		List<? super Integer> list = new ArrayList<Number>();
		int i = 2007;
		list.add(i);
		list.add(++i); //(2)
		//Number num = list.get(0);
		
	}
}
