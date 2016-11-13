import java.io.Serializable;
 

/*
 *  The “InvalidClassException” will raise, because you write a serialization class with serialVersionUID “1L” but try to retrieve it back with updated serialization class, serialVersionUID “2L”.
	The serialVersionUID have to match during the serialization and deserialization process.
	
	
 */

public class Address implements Serializable{
 	private static final long serialVersionUID = 1L;
	transient City city;	
	   String street;
	   String country;
 
	   public void setStreet(String street){
		   this.street = street;
	   }
 
	   public void setCountry(String country){
		   this.country = country;
	   }
 
	   public String getStreet(){
		   return this.street;
	   }
 
	   public String getCountry(){
		   return this.country;
	   }
 
	   public City getCity() {
		   return city;
	   }

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	   public String toString() {
    	   return new StringBuffer(" Street : ")
    	   .append(this.street)
    	   .append(" Country : ")
    	   .append(this.country)
    	   .append(" City Name : ")
    	   .append(this.city.cityName)
    	   .append(" City PinCode :")
    	   .append(this.city.pinCode)
    	   .toString();
	   }
}

class City implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cityName;
	String pinCode;
	public String getCityName() {
		return cityName;
	}

	public String getPinCode() {
		return pinCode;
	}

	public City(String cityName, String pinCode) {
		super();
		this.cityName = cityName;
		this.pinCode = pinCode;
	}
}