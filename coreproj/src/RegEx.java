import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegEx {
	//abc@gmail.com
	public static void main(String[] args) {
//		String regEx   = "\\d{1,2}/\\d{1,2}/\\d{2,4}";
//		String matcher = "10/10/11";
		
		String regEx   = "[\\w+]\\@\\w+.com";
		String matcher = "abc@gmails.com";
		
		if(validateRegEx(matcher, regEx)) {
			System.out.println("VALID");
		} else {
			System.out.println("NOT VALID");
		}
	}
	private static boolean validateRegEx(String formattedDate, String regExPattern)
	{
		Pattern p = Pattern.compile(regExPattern);
		Matcher m = p.matcher(formattedDate);
		return m.matches();
	}
}
