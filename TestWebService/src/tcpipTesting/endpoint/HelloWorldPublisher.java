package tcpipTesting.endpoint;

import javax.xml.ws.Endpoint;

import tcpipTesting.ws.HelloWorldImpl;

 
//Endpoint publisher
public class HelloWorldPublisher {
 
	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:9090/ws/hello", new HelloWorldImpl());
    }
 
}