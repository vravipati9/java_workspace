/**
 * WSAuthServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.siva.ravipati;

public class WSAuthServiceServiceLocator extends org.apache.axis.client.Service implements org.siva.ravipati.WSAuthServiceService {

    public WSAuthServiceServiceLocator() {
    }


    public WSAuthServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSAuthServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSAuthServicePort
    private java.lang.String WSAuthServicePort_address = "http://itpcitd42:9090/javabrainsWebServices/WSAuthServiceService";

    public java.lang.String getWSAuthServicePortAddress() {
        return WSAuthServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSAuthServicePortWSDDServiceName = "WSAuthServicePort";

    public java.lang.String getWSAuthServicePortWSDDServiceName() {
        return WSAuthServicePortWSDDServiceName;
    }

    public void setWSAuthServicePortWSDDServiceName(java.lang.String name) {
        WSAuthServicePortWSDDServiceName = name;
    }

    public org.siva.ravipati.WSAuthService getWSAuthServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSAuthServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSAuthServicePort(endpoint);
    }

    public org.siva.ravipati.WSAuthService getWSAuthServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.siva.ravipati.WSAuthServicePortBindingStub _stub = new org.siva.ravipati.WSAuthServicePortBindingStub(portAddress, this);
            _stub.setPortName(getWSAuthServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSAuthServicePortEndpointAddress(java.lang.String address) {
        WSAuthServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.siva.ravipati.WSAuthService.class.isAssignableFrom(serviceEndpointInterface)) {
                org.siva.ravipati.WSAuthServicePortBindingStub _stub = new org.siva.ravipati.WSAuthServicePortBindingStub(new java.net.URL(WSAuthServicePort_address), this);
                _stub.setPortName(getWSAuthServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WSAuthServicePort".equals(inputPortName)) {
            return getWSAuthServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ravipati.siva.org/", "WSAuthServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ravipati.siva.org/", "WSAuthServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSAuthServicePort".equals(portName)) {
            setWSAuthServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
