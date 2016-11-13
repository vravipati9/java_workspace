package chapter2;

import java.util.Arrays;

public class StackGeneric1<E> {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public StackGeneric1() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	public E pop() {
		if (size == 0)
			throw new EmptyStackException();
		int stackSize = --size;
		// Because E is a non-reifiable type, there’s no way the compiler can check the
		// cast at runtime
		@SuppressWarnings("unchecked")
		E result = (E)elements[stackSize];
		elements[size] = null;		
		return result;	
	}
	
	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
	public int size() {
		return size;
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
