package org.siva.ravipati;
import javax.jws.HandlerChain;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(targetNamespace="http://www.testMart123.com")
@SOAPBinding(style=Style.DOCUMENT)
@HandlerChain(file = "LogMessage_handler.xml")
//The @HandlerChain annotation is used to define a set of handlers that are invoked in response to a SOAP message
public class ShopInfo {
	
	@WebMethod
	@WebResult(partName="returnString")
	public String getShopInfo(@WebParam(partName="stringParam") String property) throws InvalidInputException {
		String response = null;
		if ("shopName".equals(property)) {
			response = "Test Mart";
		} else if ("since".equals(property)) {
			response = "since 2013";
		} else {
			throw new InvalidInputException("Invalid Input", property +" is not valid");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	@WebMethod
	@Oneway
	public void ping(String property) throws RuntimeException
	{
		System.out.println("***********in ping() start**************"+System.currentTimeMillis());
		String response = null;
		if ("shopName".equals(property)) {
			response = "Test Mart";
		} else if ("since".equals(property)) {
			response = "since 2013";
		} else {
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("***********in ping() end**************"+System.currentTimeMillis());
	}	
}
