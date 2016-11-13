import java.rmi.RemoteException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.rpc.ServiceException;

import org.siva.ravipati.TestMartCatalog;
import org.siva.ravipati.TestMartCatalog_Service;

import com.testMart123.www.InvalidInputException;
import com.testMart123.www.ShopInfo;
import com.testMart123.www.ShopInfoServiceLocator;
import com.testmart.Product;


public class ShopInfoClient {

	public static void main(String[] args) {
		ShopInfoServiceLocator service = new ShopInfoServiceLocator();
		
		
		String str = null;
		try {
			ShopInfo shopInfo = service.getShopInfoPort();
			try {
				System.out.println("Client class");
				long startTime = System.currentTimeMillis();
				str = shopInfo.getShopInfo("shopName");
				long duration = System.currentTimeMillis() - startTime;
				System.out.println("Method took " + duration/1000 + " seconds to run");
				
				long startTime1 = System.currentTimeMillis();
				shopInfo.ping("since");
				long duration1 = System.currentTimeMillis() - startTime1;
				System.out.println("Ping Method took " + duration1 + "milliseconds to run");
		        
			} catch (InvalidInputException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Returned From WS::::::::"+str);
		//Marshaller is used to convert Java Object to XML
		//UnMarshaller is used to convert XML to Java Obj.
		
	}

}
