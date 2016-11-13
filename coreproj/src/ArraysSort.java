import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
public class ArraysSort {
	public static void main(String[] args) {
		Object[] objArr = {new String("siva"), new Integer(12), new Boolean(true) };
		//Arrays.sort(objArr);
		//out.println("Done"+MAX_VALUE);					
		Properties p = System.getProperties();
		Enumeration e = p.keys();
		while(e.hasMoreElements()) {
			
		}
		p.setProperty("cssProp", "css.properties");
		p.list(System.out);
		Runtime  rt = Runtime.getRuntime();
		long l1 = rt.freeMemory();
		System.out.println(l1);
		StringBuffer s = new StringBuffer("1");
		for(int i=0;i<10000;i++) {
			s = s.append(i);
		}
		long l2 = rt.freeMemory();
		System.out.println(l2-l1);

		String[] elements = { "for", "tea", "too" };
		String first = (elements.length > 0)? elements[0] : null;
		
		String s2 = new String("One");
		System.out.println(s2.hashCode());
		

		String s1 = new String("One");
		System.out.println(s1.hashCode());
	}
	protected void finalize() {
		System.out.println("finalize");
	}
}
