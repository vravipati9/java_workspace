import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.siva.ravipati.TestMartCatalog;
import org.siva.ravipati.TestMartCatalog_Service;

import com.testmart.Product;

public class TestMartCatalogClient {

	public static void main(String[] args) {
		TestMartCatalog_Service service = new TestMartCatalog_Service();
		TestMartCatalog testMartCatalog = service.getTestMartCatalogPort();
		List<Product> products = testMartCatalog.getProductsV2("test");
		for (Product product : products) {
			System.out.println("Products...."+product);
		}
		
		//Marshaller is used to convert Java Object to XML
		//UnMarshaller is used to convert XML to Java Obj.
		
	}

}
