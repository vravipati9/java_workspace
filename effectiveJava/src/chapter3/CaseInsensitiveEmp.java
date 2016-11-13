package chapter3;

import java.util.Comparator;

public class CaseInsensitiveEmp implements Comparable<CaseInsensitiveEmp> {

	public String empName;
	public int empAge;
	public float salary;
	
	public int compareTo(CaseInsensitiveEmp o) {
		return String.CASE_INSENSITIVE_ORDER.compare(empName, o.empName);
	}
	
	public CaseInsensitiveEmp(String empName, int empAge, float salary) {
		this.empName = empName;
		this.empAge = empAge;
		this.salary = salary;
	}
	
	@Override
	public boolean equals(Object obj) throws ClassCastException {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		// TODO Auto-generated method stub
		try {
			return super.clone();
		} finally {
			
		}
	}
	
}
