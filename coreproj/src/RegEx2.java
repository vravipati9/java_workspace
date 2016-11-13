import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 *  \d A digit
	\s A whitespace character
    \w A word character (letters, digits, or "_" (underscore))
    * Zero or more occurrences
	? Zero or one occurrence
	+ One or more
 */
public class RegEx2 {

	public static void main(String[] args) {
//		String regExPattern = ".*xx"; 
//		String matcher	= "yyxxxyxx";

		Console c = System.console();
		System.out.println("Enter regExPattern String ");
		String regExPattern = c.readLine("%d", "regExPattern?: ");
		System.out.println("Enter matcher String ");
		String matcher = c.readLine("%s", "matcher?: ");

		Pattern p = Pattern.compile(regExPattern);
		Matcher m = p.matcher(matcher);
		RegEx2.iterateMatcher(m);
		
	}
	static void iterateMatcher(Matcher m) {
		while(m.find()) {
			System.out.print(m.group()+"	");
		}
	}
}
