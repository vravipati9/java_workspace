package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class StackGeneric<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	@SuppressWarnings("unchecked")
	public StackGeneric() {
		elements = (E[])new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	
	public E[] getElements() {
		return elements;
	}


	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	public void pushAll(Iterable<? extends E> e) {
		for (E e2 : e) {
			push(e2);
		}
	}	
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
	public int size() {
		return size;
	}
	
	public E pop() {
		if (size == 0)
			throw new EmptyStackException();
		int stackSize = --size;
		E result = elements[stackSize];
		elements[size] = null;		
		return result;	
	}

	public Object pop(int index) {
		if (size == 0)
			throw new EmptyStackException();
		E result = elements[index];
		elements[size] = null;	// Eliminate obsolete reference	
		return result;	
	}

	public void popAll(Collection<? super E> dst) {
		while (!isEmpty())
			dst.add(pop());
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

	// Little program to exercise our generic Stack
	public static void main(String[] args) {
		// will not compile, Parameterized types are invariant.
//		StackGeneric<Number> stack = new StackGeneric<Number>();
//		Iterable<Integer> intList = takeWhile(Arrays.asList(1,5,2,4));
//		stack.pushAll(intList);
		
		StackGeneric<Number> stack = new StackGeneric<Number>();
		Iterable<Integer> intList = takeWhile(Arrays.asList(1,5,2,4));
		stack.pushAll(intList);
		
		System.out.println(stack);
		Collection<Object> destList = new ArrayList<Object>();
		stack.popAll(destList);
		System.out.println(destList);
		
		
	}
	
	public static <T> Iterable<T> takeWhile(final List<T> elements) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					int size = elements.size() - 1;
					@Override
					public boolean hasNext() {
						return  size >= 0;
					}
					
					@Override
					public T next() {
						if (hasNext()) {
							return elements.get(size--);
						} else {
							throw new NoSuchElementException();
						}
					}
					
					@Override
					public void remove() {
						// TODO Auto-generated method stub
						
					}
					
				};
			}
		};
	}
}
