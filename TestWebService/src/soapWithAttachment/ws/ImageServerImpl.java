package soapWithAttachment.ws;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;
 
//Service Implementation Bean
@MTOM
@WebService(endpointInterface = "soapWithAttachment.ws.ImageServer")
public class ImageServerImpl implements ImageServer{
 
	@Override
	public Image downloadImage(String name) {
 
		try {
			System.out.println("In downlaod images");
			File image = new File("c:\\generated\\" + name);
			System.out.println("After reading images");
			return ImageIO.read(image);
 
		} catch (IOException e) {
 
			e.printStackTrace();
			return null; 
 
		}
	}
 
	@Override
	public String uploadImage(Image data) {
 
		if(data!=null){
			//store somewhere
			return "Upload Successful";
		}
 
		throw new WebServiceException("Upload Failed!");
 
	}
 
}