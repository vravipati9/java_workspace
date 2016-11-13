
public class CompanyProxy implements ExternalProxy {

	public String[] getAllCompanies() {
		String[] companyArr1 =  {"one"};
		String[] companyArr2 = new String[2];
		companyArr2[0] = "one";
		
		return new String[] {"one"};
	}
	
	public CompanyProxy() {
		System.out.println("Company Proxy obj created..");
	}

}
