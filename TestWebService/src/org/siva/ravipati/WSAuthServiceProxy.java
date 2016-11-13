package org.siva.ravipati;

public class WSAuthServiceProxy implements org.siva.ravipati.WSAuthService {
  private String _endpoint = null;
  private org.siva.ravipati.WSAuthService wSAuthService = null;
  
  public WSAuthServiceProxy() {
    _initWSAuthServiceProxy();
  }
  
  public WSAuthServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSAuthServiceProxy();
  }
  
  private void _initWSAuthServiceProxy() {
    try {
      wSAuthService = (new org.siva.ravipati.WSAuthServiceServiceLocator()).getWSAuthServicePort();
      if (wSAuthService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSAuthService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSAuthService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSAuthService != null)
      ((javax.xml.rpc.Stub)wSAuthService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.siva.ravipati.WSAuthService getWSAuthService() {
    if (wSAuthService == null)
      _initWSAuthServiceProxy();
    return wSAuthService;
  }
  
  public boolean auth_method() throws java.rmi.RemoteException{
    if (wSAuthService == null)
      _initWSAuthServiceProxy();
    return wSAuthService.auth_method();
  }
  
  
}