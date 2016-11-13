import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherAppendReplacement {
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer();
		String candidateString = "My name is Bond. James Bond.";
		String replacement = "$1 Waldo $2";
		
		Pattern p = Pattern.compile("(James) (Bond)");
		Matcher matcher = p.matcher(candidateString);
		while(matcher.find()) {
			System.out.print(matcher.group()+"	"+matcher.start());
		}
		matcher.appendReplacement(sb, replacement);

		String msg = sb.toString();
		System.out.println("rsr	:"+msg);
	}

}
