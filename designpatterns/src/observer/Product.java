package observer;

import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {
	
	String productName;
	List<Observer> list = new ArrayList<Observer>();
	
	private boolean available;
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
		if (available == true) {
			notifyObservers();
		}
		
	}

	@Override
	public void registerObserver(Observer observer) {
		list.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		list.remove(observer);
	}

	@Override
	public void notifyObservers() {
		System.out.println("Notifying all registerd customers, when product becomes available");
		for (Observer observer : list) {
			observer.update(productName);
		}
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public List<Observer> getList() {
		return list;
	}

	public void setList(List<Observer> list) {
		this.list = list;
	}
	
}
