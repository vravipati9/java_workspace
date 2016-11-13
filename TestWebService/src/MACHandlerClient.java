import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.siva.ravipati.MACHandler;
import org.siva.ravipati.MACHandlerService;
import org.siva.ravipati.TestMartCatalog;
import org.siva.ravipati.TestMartCatalog_Service;

import com.testmart.Product;

public class MACHandlerClient {

	public static void main(String[] args) {
		System.out.println("<<<<<<<<In MACHandlerClient>>>>>>>");
		MACHandlerService service = new MACHandlerService();
		MACHandler port = service.getMACHandler();
		String serverName = port.getServerName();
		System.out.println("Retrieved Server name....."+serverName);
	}

}
