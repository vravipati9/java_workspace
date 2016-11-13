/**
 * ShopInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.testMart123.www;

public interface ShopInfo extends java.rmi.Remote {
    public void ping(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String getShopInfo(java.lang.String arg0) throws java.rmi.RemoteException, com.testMart123.www.InvalidInputException;
}
