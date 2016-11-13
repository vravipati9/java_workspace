package chapter2;

public class NewArrayList {
	Object[] object;
	public static final int initialCapacity = 10;
	public static int size = 0;
	
	public NewArrayList() {
		object = new Object[initialCapacity];
	}
	
	public boolean add(Object o) {
		object[size] = o;
        size++;
        return true;
	}
	
	public int size() {
		return size;
	}
}
