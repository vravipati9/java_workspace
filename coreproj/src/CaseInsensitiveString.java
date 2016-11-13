public final class CaseInsensitiveString {
	String str = "";
	public CaseInsensitiveString(String str) {
		if (str == null) throw new NullPointerException();
		this.str = str;
	}
	@Override
	public boolean equals(Object obj) {
/*		if (obj instanceof CaseInsensitiveString) {
			System.out.println("CaseInsensitiveString Method");
			return str.equalsIgnoreCase(((CaseInsensitiveString) obj).str);
		}
		if (obj instanceof String) {
			System.out.println("String Method");
			return str.equalsIgnoreCase((String)obj);
		}
*/
		//return obj instanceof CaseInsensitiveString && ((CaseInsensitiveString)obj).str.equalsIgnoreCase(str);
		if (obj instanceof CaseInsensitiveString) {
			System.out.println("obj is instanceof CaseInsensitiveString");
			return ((CaseInsensitiveString)obj).str.equalsIgnoreCase(str);
		} else {
			System.out.println("obj is not instanceof CaseInsensitiveString");
		}
		return false;
		
	}
	public static void main(String[] args) {
		CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
		String s = "polish";
		System.out.println("cis.equals(s)::"+cis.equals(s));
		//mOne(cis);
		System.out.println("cis.equals(s)::"+s.equals(cis));

	}
	static void mOne(Object cis) {
		if (cis instanceof CaseInsensitiveString) {
			System.out.println("Obj Mathc");
		}
	}
}
