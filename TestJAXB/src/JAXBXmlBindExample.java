import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBXmlBindExample {
  
  
    public static void main(String args[]){
      
        //Creating booking object for marshaling into XML document
        Booking booking = new Booking();
        booking.setName("Rohit");
        booking.setContact(983672431);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = formatter.parse("11/09/2012");
            endDate = formatter.parse("14/09/2012");
        } catch (ParseException ex) {
            Logger.getLogger(JAXBXmlBindExample.class.getName()).log(Level.SEVERE,
                                                                         null, ex);
        }
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setAddress("Mumbai");
      
      
        JAXBContext jaxbCtx = null;
        StringWriter xmlWriter = null;
        try {
            //XML Binding code using JAXB
          
            jaxbCtx = JAXBContext.newInstance(Booking.class);
            xmlWriter = new StringWriter();
            Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(booking, xmlWriter);
            System.out.println("XML Marshal example in Java");
            System.out.println(xmlWriter);
          
            //Booking b = (Booking) jaxbCtx.createUnmarshaller().unmarshal(new StringReader(xmlWriter.toString()));
                                               
            
            Booking b = (Booking)jaxbCtx.createUnmarshaller().unmarshal(new File("src/booking.xml"));
            System.out.println("XML Unmarshal example in JAva");
            System.out.println(b.toString());
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBXmlBindExample.class.getName()).log(Level.SEVERE,
                                                                          null, ex);
        }
    }
}


