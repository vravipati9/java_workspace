package org.siva.ravipati;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

/*
 * Create a SOAP handler and attach it in server side, to retrieve the mac address in SOAP header block from every incoming SOAP message. 
 * And do validation to allow only computer with MAC address “90-4C-E5-44-B9-8F” to access this published service. 
 * If an invalid client try to access the service, throw a SOAPFaultException back to the client.
 */

@WebService(name="MACHandler", serviceName="MACHandlerService", portName="MAC_Handler")
@HandlerChain(file = "mac_handler.xml")
public class WebServiceHandlerDemo {
	
	@WebMethod
	public String getServerName() {
		System.out.println("********In WebServiceHandlerDemo*********");
		return "RSR Server";
	}
}
