package generics;

import java.util.*;

public class WildCardEx1 {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("ads");c.add(100);
		printCollectionThrowsClassCastExp(c);	// we are passing String & Integer and Generic Method only accepts Strings
		
		Collection<Object> c2 = new ArrayList<Object>();	// We can add any class which is sub type of Object.
		c2.add("");	c2.add(12);
		
		Collection<?> c1 = new ArrayList<Number>();
		//c1.add();	We can not add anything in this. because it is unknown type.
		printCollectionWildCards(c1);
	}
	
	static void printCollectionThrowsClassCastExp(Collection<String> c) {
	    for (String e : c) {
	        System.out.println(e);
	    }
	}
	static void printCollectionAceptsObjSubTypes(Collection<Object> c) {
	    for (Object e : c) {
	        System.out.println(e);
	    }
	}
	
	static void printCollectionWildCards(Collection<?> c) {
	    for (Object e : c) {
	        System.out.println(e);
	    }
	}
}
