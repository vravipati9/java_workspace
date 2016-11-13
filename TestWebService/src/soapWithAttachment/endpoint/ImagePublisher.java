package soapWithAttachment.endpoint;

import javax.xml.ws.Endpoint;

import soapWithAttachment.ws.ImageServerImpl;

//Endpoint publisher
public class ImagePublisher{
 
    public static void main(String[] args) {
 
	Endpoint.publish("http://localhost:9991/ws/image", new ImageServerImpl());
 
	System.out.println("Server is published!");
 
    }
 
}