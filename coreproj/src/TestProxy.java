import java.util.Arrays;
import java.util.List;


public class TestProxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServiceClientFactory serviceFactory = new ServiceClientFactoryImpl();
		String[] companys = serviceFactory.externalProxy().getAllCompanies();
		List companyList = Arrays.asList(companys);
		System.out.println(companyList);
		String[] companys1 = serviceFactory.externalProxy().getAllCompanies();
	}

}
