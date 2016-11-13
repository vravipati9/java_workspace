import java.text.*;

public class NumberFormatEx1 {
	public static void main(String[] args) {
		String s = "12.2232a";
		double d = 987.123456d;
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(9);
		System.out.println(nf.format(d) + " ");
		try {
			Float f = Float.parseFloat(s);
			System.out.println(nf.parse(s));
		} catch (ParseException e) {
			System.out.println("got exc");
		} 
	}
}