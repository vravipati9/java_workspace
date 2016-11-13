package chapter3;

import java.util.ArrayList;
import java.util.List;

//Broken - violates symmetry! - Pages 36-37

public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        if (s == null)
            throw new NullPointerException();
        this.s = s;
    }

    // Broken - violates symmetry!
    @Override public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString) {
        	String ss =  ((CaseInsensitiveString) o).s;
        	System.out.println(ss);
        	return s.equalsIgnoreCase(s);
        }
        if (o instanceof String)  // One-way interoperability!
            return s.equalsIgnoreCase((String) o);
        return false;
    }

 //   This version is correct.
/*   public boolean equals(Object o) {
	   System.out.println("equals method");
       return o instanceof CaseInsensitiveString &&
           ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
   }*/

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String str = "polish";
        System.out.println("cis.equals(s)   " + cis.equals(str));
        System.out.println("---------------");
        System.out.println("s.equals(cis)   " + str.equals(cis));
        
        List<CaseInsensitiveString> list = new ArrayList<CaseInsensitiveString>();
       	list.add(cis);
       	System.out.println("list.contains(str):::"+list.contains(str));
    }
}
