public class InherientenceEx extends Sub_Cls{
	public static void main(String a[]) {
		Sub_Cls s1 = new Sub_Cls();
		s1.mOne();
		System.out.println("--------------");
		Super_Cls s2 = new Super_Cls();
		s2.mOne();
		System.out.println("--------------");
		Super_Cls s3 = new Sub_Cls();
		s3.mOne();
		
		System.out.println("***********");
		InherientenceEx ex = new InherientenceEx();
		ex.mThree();
	}
}
