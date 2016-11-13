import java.util.regex.*;

public class RegEx4 {
	public static void main(String[] args) {
		String matcher = "ab2c4d67";
		String compiler = "\\d?";
		Pattern p = Pattern.compile(compiler);
		Matcher m = p.matcher(matcher);
		int count = 0;
		while (m.find())
			count++;
		System.out.print(count);
		
		String test = "Test A. Test B. Test C.";
		String regex = "\\.\\s*";
		String[] result = test.split(regex);
		for (String string : result) {
			System.out.print(">"+string+"<");
		}
	}
	
}