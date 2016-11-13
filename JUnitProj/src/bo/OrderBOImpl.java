package bo;
import dao.*;
public class OrderBOImpl implements OrderBO {
	
	OrderDAO orderDAO;
	
	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	public boolean placeOrder() {
		return orderDAO.processOrder();
	}

	@Override
	public int getTotalOrders() {
		// TODO Auto-generated method stub
		return orderDAO.getOrdersCount();
	}

	@Override
	public boolean placeOrder(String orderName) {
		// TODO Auto-generated method stub
		return orderDAO.processOrder(orderName);
	}
	
	
}
