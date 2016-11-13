import javax.naming.InitialContext;
import javax.naming.NamingException;

import sessionbeans.stateful.MyBean;


public class StanaloneTest {
	public static void main(String a[]) throws NamingException {
		InitialContext context = new InitialContext();
		Object o = context.lookup("java:global/TestEjbWeb/MyBean");
		MyBean myBean = (MyBean)o;
		myBean.increment(myBean);
		System.out.println("Number Retrieved from Session Bean:::::"+myBean.getNumber());
		
		myBean.increment(myBean);
		System.out.println("Number Retrieved from Session Bean:::::"+myBean.getNumber());
	}
}
