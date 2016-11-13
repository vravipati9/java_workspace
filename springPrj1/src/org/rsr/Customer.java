package org.rsr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer {
	private String customerId;
	private String customerName;
	@Autowired
	private Address address;
	private List<String> acctTypes;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<String> getAcctTypes() {
		return acctTypes;
	}
	public void setAcctTypes(List<String> acctTypes) {
		this.acctTypes = acctTypes;
	}
	
	public Customer(String customerId) {
		this.customerId = customerId;
		
	}
	
	
	
}
