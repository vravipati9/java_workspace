package org.siva.ravipati;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public class WSAuthService {

	@Resource
	WebServiceContext wsctx;
	 
	@WebMethod
	@WebResult(partName = "returnString")
	public boolean auth_method() {
		System.out.println("**********authenticate()*************");
		MessageContext mctx = wsctx.getMessageContext();
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");
        System.out.println("userList::"+userList+"      passList::"+passList);
		return true;
	}
}
