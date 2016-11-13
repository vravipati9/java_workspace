class TV {
	void watch() {
		System.out.print("TV WATCH");
	}
}

class LED extends TV {
	void watch() {
		System.out.print("LED TV WATCH");
	}	
}
class HD extends LED {
	void watch() {
		System.out.print("HD TV WATCH");
	}
}

public class ClassCastExceptionEx {
	static final int number1 = 5;
	static final int number2= 6;
	static int number3 = 5;
	static int number4= 6;
	public static void main(String a[]) {

		TV tv = new TV();
		LED led = new LED();
		TV tv1 = new LED();
		LED led1 = (LED)tv1;
		
		//LED led2 = (LED)tv;	//ClassCastException

		led1.watch();
		System.out.println("successfully comiled");
		
		
		
		int product1 = number1 * number2; //line A
		int product2 = number3 * number4; //line B
		
		System.out.println(product1);
		System.out.println(product2);
			
	}
}
