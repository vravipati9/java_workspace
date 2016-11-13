import static java.lang.Integer.*;

abstract class Sales {
	protected  double getSalesAmount() {
		return 12.23;
	}
	
	public  double getCommision() { return 0.0;};
}

public class AbstractT extends Sales {

	public static void main(String[] args) {
		Sales s = new AbstractT();
		
		final int i = 12;
		//final long l = 12;
		doCalc(i);
		System.out.println(s.getCommision());
	}
	static void doCalc(int i) {
		System.out.println("called doCalc");
	}
//	public double getSalesAmount() {
//		return MAX_VALUE;
//	}
	public double getCommision() {
		return getSalesAmount() * 0.15;
	}
}
