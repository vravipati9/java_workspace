package chapter3;
import java.math.BigInteger;
import java.util.*;

public class PhoneNumber {
	private final short areaCode;
	private final short prefix;
	private final short lineNumber;

	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		// TODO Auto-generated constructor stub

		this.areaCode = (short) areaCode;
		this.prefix = (short) prefix;
		this.lineNumber = (short) lineNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == this) 
			return true;
		
		if (!(obj instanceof PhoneNumber)) 
			return false;

		PhoneNumber phoneNumber = (PhoneNumber)obj;
		
		if (phoneNumber.areaCode == areaCode && phoneNumber.prefix == prefix && phoneNumber.lineNumber == lineNumber) 
			return true;

		return false;
	}
	
	@Override 
	public int hashCode() {
		int result = 17;
		result = 31 * result + areaCode;
		result = 31 * result + prefix;
		result = 31 * result + lineNumber;
		System.out.println("HashCode:::"+result);
		return result;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
	}
	public static void main(String a[]) {
		Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
		PhoneNumber pn = new PhoneNumber(707, 867, 5309);
		m.put(pn, "Jenny");
		System.out.println(m);
		System.out.println("Element retrieved from Map..."+m.get(new PhoneNumber(707, 867, 5309)));
		System.out.println("Element retrieved from Map..."+m.containsKey(new PhoneNumber(707, 867, 5309)));
		
	}
}
