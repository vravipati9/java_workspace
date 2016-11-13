import java.util.ArrayList;
import java.util.List;

class Rental<T> {
	private List<T> rentalPool;
	private int maxNum;

	public Rental(int maxNum, List<T> rentalPool) {
		this.maxNum = maxNum;
		this.rentalPool = rentalPool;
	}

	public T getRental() {
		// blocks until there's something available
		return rentalPool.get(0);
	}

	public void returnRental(T o) {
		rentalPool.add(o);
	}
}

public class TestRental {
public static void main (String[] args) {
	Cars c1 = new Cars();Cars c2 = new Cars();
	List<Cars> carList = new ArrayList<Cars>();
	carList.add(c1);
	carList.add(c2);
	Rental<Cars> cars = new Rental<Cars>(2, carList);
	Cars car = cars.getRental();
	
}
}

class Cars {
	
}
