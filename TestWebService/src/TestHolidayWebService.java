import java.rmi.RemoteException;

import org.apache.axis.message.MessageElement;

import com._27seconds.www.Holidays.US.GetHolidaysForYearResponseGetHolidaysForYearResult;
import com._27seconds.www.Holidays.US.USHolidayServiceSoapProxy;


public class TestHolidayWebService {

	public static void main(String[] args) throws RemoteException {
		USHolidayServiceSoapProxy sp = new USHolidayServiceSoapProxy();
		GetHolidaysForYearResponseGetHolidaysForYearResult result = sp.getHolidaysForYear(2014); 
		MessageElement[] me = result.get_any();
		if (me.length > 1) {
			String messageElement = me[1].toString();
			System.out.println(messageElement);
		}
	}
}
