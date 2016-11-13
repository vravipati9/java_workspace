package chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableTest {
	public static void main(String a[]) {
		CaseInsensitiveEmp cie1 = new CaseInsensitiveEmp("Siva", 29, 1222.12f);
		CaseInsensitiveEmp cie2 = new CaseInsensitiveEmp("Veera", 32, 3434.22f);
		CaseInsensitiveEmp cie3 = new CaseInsensitiveEmp("venkata", 31, 4452.322f);
		List<CaseInsensitiveEmp> list = new ArrayList<CaseInsensitiveEmp>();
		Collections.addAll(list, cie1, cie2, cie3);
		Collections.sort(list);
		System.out.println("Sort by Name::"+list);
		Collections.sort(list, sortWithAge());
		System.out.println("Sort by Name::"+list);
	}
	
    public static Comparator<CaseInsensitiveEmp> sortWithAge() {
        return new Comparator<CaseInsensitiveEmp>() {
            public int compare(CaseInsensitiveEmp obj1, CaseInsensitiveEmp obj2) {
            	//return obj1.empAge - obj2.empAge;
            	return (obj1.empAge<obj2.empAge ? -1 : (obj1.empAge==obj2.empAge ? 0 : 1));
            }
        };
    }
}
