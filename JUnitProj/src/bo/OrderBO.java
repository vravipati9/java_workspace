package bo;

public interface OrderBO {
	boolean placeOrder();
	
	int getTotalOrders();
	
	boolean placeOrder(String orderName);
}
