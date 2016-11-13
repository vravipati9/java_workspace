package observer;

public class ObserverPatternTest {
	public static void main(String[] args) {
		Customer customer1 = new Customer("John");
		Customer customer2 = new Customer("Paul");
		
		Product iphone6 = new Product();
		iphone6.setProductName("IPhone6");
		iphone6.setAvailable(false);
		
		iphone6.registerObserver(customer1);
		iphone6.registerObserver(customer2);
		
		//After few days
		iphone6.setAvailable(true);

		// Customer 2 wants to unregister for iPhone6 availability
		iphone6.removeObserver(customer2);
		
		iphone6.setAvailable(true);

	}
}
