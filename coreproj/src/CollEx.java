import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CollEx {
	public static void main(String a[]) {
		//List<Integer> result = mOne();
		//System.out.println(result);
		testHashMap();
	}
	private static List<Integer> mOne() {
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(10);l1.add(30);l1.add(20);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(60);
		List<Integer> l3 = new ArrayList<Integer>();
		for (Integer i : l1) {
			if (l2.contains(i)) {
				l3.add(i);
			}
		}
		List<EmpPOJO> empPOJOList = new ArrayList<EmpPOJO>();
		EmpPOJO empPOJO = new EmpPOJO();
		empPOJO.setEmpName("rsr");
		EmpPOJO empPOJO1 = new EmpPOJO();
		empPOJO1.setEmpName("rvv");
		empPOJOList.add(empPOJO);empPOJOList.add(empPOJO1);
		EmpPOJO empPOJO2 = empPOJOList.get(1);
		System.out.println(empPOJO2.getEmpName());
		empPOJO2.setEmpName("siva");
		EmpPOJO empPOJO3 = empPOJOList.get(1);
		System.out.println(empPOJO3.getEmpName());
		if (l3 != null) {
			return l3;
		} else {
			return null;
		}
	}
	
	static void testHashMap() {
		Map<EmpPOJO, String> map = new HashMap<EmpPOJO, String>();
		EmpPOJO emp = new EmpPOJO();
		emp.setEmpName("siva");
		System.out.println("1");
		map.put(emp, "siva value");
		
		EmpPOJO emp1 = new EmpPOJO();
		emp.setEmpName("siva");
		
		System.out.println(map.get(emp1));
		emp.setEmpName("krish");
		
		System.out.println(map.get(emp));
		
		
		
		
	}
}
