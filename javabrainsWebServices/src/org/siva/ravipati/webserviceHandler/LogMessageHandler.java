package org.siva.ravipati.webserviceHandler;



import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class LogMessageHandler implements SOAPHandler<SOAPMessageContext> {

    public boolean handleMessage(SOAPMessageContext messageContext) {
    	System.out.println("*********In handleMessage() block***********");
    	log(messageContext);
         return true;
    }

    public Set<QName> getHeaders() {
        return Collections.EMPTY_SET;
    }

    public boolean handleFault(SOAPMessageContext messageContext) {
    	System.out.println("*********In handleFault() block***********");
        return true;
    }

    public void close(MessageContext context) {
    }

    private void log(SOAPMessageContext messageContext) {
    	 final boolean outboundProperty = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
    	 System.out.println("**********WebServiceMessageHandler log()*****outbound*"+outboundProperty);
    	 // To add security
    	 /*   if (outboundProperty) {
    	        try {
    	          final SOAPEnvelope envelope = messageContext.getMessage().getSOAPPart().getEnvelope();
    	          final SOAPHeader header = envelope.getHeader();
    	          System.out.println("Before adding extra header.....\n"+header);
    	          final SOAPElement security = header
    	                                             .addChildElement("Security", "wsse",
    	                                                              "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

    	          SOAPElement usernameToken = security.addChildElement("UsernameToken", "wsse");
    	          usernameToken
    	                       .addAttribute(new QName("wsu:Id"),
    	                                     "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
    	          SOAPElement usernameElement = usernameToken.addChildElement("Username", "wsse");
    	          usernameElement.addTextNode("siva");
    	          SOAPElement passwordElement = usernameToken.addChildElement("Password", "wsse");
    	          passwordElement
    	                         .setAttribute("Type",
    	                                       "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
    	          passwordElement.addTextNode("abc");
    	          System.out.println("After adding extra header.....\n"+header);
    	        } catch (SOAPException e) {
    	          throw new RuntimeException(e.getMessage(), e);
    	        }
    	      }
    	 */
        SOAPMessage msg = messageContext.getMessage(); //Line 1
     try {
         msg.writeTo(System.out);  //Line 3
     } catch (SOAPException ex) {
         //Logger.getLogger(LogMessageHandler.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("Exception Caught......."+ex);
     } catch (IOException ex) {
         //Logger.getLogger(LogMessageHandler.class.getName()).log(Level.SEVERE, null, ex);
    	 System.out.println("Exception Caught......."+ex);
     }
}

}