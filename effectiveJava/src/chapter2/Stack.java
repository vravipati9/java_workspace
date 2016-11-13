package chapter2;

import java.util.Arrays;

public class Stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	
	public Object[] getElements() {
		return elements;
	}


	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		int stackSize = --size;
		Object result = elements[stackSize];
		//elements[size] = null;		
		return result;	
	}

	public Object pop(int index) {
		if (size == 0)
			throw new EmptyStackException();
		Object result = elements[index];
		//elements[size] = null;		
		return result;	
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		for (Object object : elements) {
			str+= object;
		}
		return str;
	}
	
}
