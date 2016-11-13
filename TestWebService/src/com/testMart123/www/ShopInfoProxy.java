package com.testMart123.www;

public class ShopInfoProxy implements com.testMart123.www.ShopInfo {
  private String _endpoint = null;
  private com.testMart123.www.ShopInfo shopInfo = null;
  
  public ShopInfoProxy() {
    _initShopInfoProxy();
  }
  
  public ShopInfoProxy(String endpoint) {
    _endpoint = endpoint;
    _initShopInfoProxy();
  }
  
  private void _initShopInfoProxy() {
    try {
      shopInfo = (new com.testMart123.www.ShopInfoServiceLocator()).getShopInfoPort();
      if (shopInfo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)shopInfo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)shopInfo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (shopInfo != null)
      ((javax.xml.rpc.Stub)shopInfo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.testMart123.www.ShopInfo getShopInfo() {
    if (shopInfo == null)
      _initShopInfoProxy();
    return shopInfo;
  }
  
  public java.lang.String getShopInfo(java.lang.String arg0) throws java.rmi.RemoteException, com.testMart123.www.InvalidInputException{
    if (shopInfo == null)
      _initShopInfoProxy();
    return shopInfo.getShopInfo(arg0);
  }
  
  public void ping(java.lang.String arg0) throws java.rmi.RemoteException{
    if (shopInfo == null)
      _initShopInfoProxy();
    shopInfo.ping(arg0);
  }
  
  
}