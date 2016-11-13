import java.io.IOException;


public class ExternalProxyFactory {
	public static ExternalProxy getExternalProxy() {
	    
	    CompanyProxy  proxy = null;
	    try {
	    	System.out.println("Proxy obj created");
	      proxy = new CompanyProxy();
	    }
	    catch (Exception ex) {
	      //log.error("Error loading NJLogisticsProxy properties file.", ex);
	      //throw new IOException();
	    }
	    return proxy;
	  }
}
