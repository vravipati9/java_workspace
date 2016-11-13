package dao;


public interface OrderDAO {
	boolean processOrder();	
	
	int getOrdersCount();
	
	boolean processOrder(String orderName);
}
