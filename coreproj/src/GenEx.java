import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GenEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=0;i<5;i++) {
			System.out.println("outer loop");
			for (int j=0;j<5;j++) {
				if (i==j) {
					System.out.println("equal");
					break;
				}
				System.out.println("end of inner loop");
			}
		}


		
		//List<EmpPOJO> list = getStrings();
		//Iterator it = list.iterator();
		//while (it.hasNext()) {
		//EmpPOJO empPOJO =(EmpPOJO) it.next();
		//System.out.println(empPOJO.getEmpName());


		//}
	}
	static List getStrings() {
		EmpPOJO empPOJO1 = new EmpPOJO();
		empPOJO1.setEmpName("siva");empPOJO1.setEmpNo("1");
		EmpPOJO empPOJO2 = new EmpPOJO();empPOJO2.setEmpName("rama");empPOJO2.setEmpNo("2");
		EmpPOJO empPOJO3 = new EmpPOJO();empPOJO3.setEmpName("krishna");empPOJO3.setEmpNo("3");


		List l = new ArrayList();
		l.add(empPOJO1);l.add(empPOJO2);l.add(empPOJO3);
		Collections.sort(l);
		return l;
	}

}
