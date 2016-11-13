import java.util.*;

class SplitTest {
	public static void main(String[] args) {
//		String str = "ab5 ccc 45 @";
//		String deli = "\\d";
		
		String str = "abc.d ef. ghi";
		String deli = "\\.";
		String[] tokens = str.split(deli);
		System.out.println("count " + tokens.length);
		for (String s : tokens)
			System.out.println(">" + s + "<");
		System.out.println(" \""+"siva"+"\" ");	//	" \
		System.out.println(" \' ");	//	" \
	}
}