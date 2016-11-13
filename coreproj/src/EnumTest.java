public class EnumTest {
	static Weather w;
	public static void main(String[] args) {
		System.out.println("*****");
		System.out.print(w.RAINY.count + "   "  + w.SUNNY.count);
	}
}
enum Weather {
	RAINY, SUNNY;
	int count = 0;
	Weather() {
	count++;
	System.out.print("count"+count);	
	}
}
