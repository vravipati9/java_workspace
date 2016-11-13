public class EmpPOJO {

	public String empNo ="25"; 
	private String empName;
	public String getEmpNo() {
		return this.empNo;
	}
	public void setEmpNo(String empNo) {
		//this.empNo = empNo;
		this.empNo = "12";
	}
	public String getEmpName() {
		return this.empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String toString() {
		return empName.toString();
	}
	public boolean endsWith(String suffix) {
		return empName.endsWith(suffix);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		System.out.println("HashCode>>>"+empName+">>>>><<<<"+result);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpPOJO other = (EmpPOJO) obj;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	

}
