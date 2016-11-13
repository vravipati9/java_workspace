package org.siva.ravipati;

import javax.xml.ws.Endpoint;


public class WSDLPublisher {
	public static void main(String a[]) {
		System.out.println("endorsedList.."+System.getProperty("java.endorsed.dirs"));
		Endpoint.publish("http://localhost:2121/shopInfo", new ShopInfo());
	}
}
