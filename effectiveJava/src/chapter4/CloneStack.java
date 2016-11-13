package chapter4;

import java.util.Arrays;

import chapter2.EmptyStackException;

public class CloneStack  implements Cloneable {
	   private Object[] elements;
	    private int size = 0;
	    private static final int DEFAULT_INITIAL_CAPACITY = 16;

	    public CloneStack() {
	        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
	    }

	    public void push(Object e) {
	        ensureCapacity();
	        elements[size++] = e;
	        //Object o = elements[--size];
	    }

	    public Object pop() {
	        if (size == 0)
	            throw new EmptyStackException();
	        
	        Object result = elements[--size];
	        elements[size] = null; // Eliminate obsolete reference
	        return result;
	    }
	    public boolean isEmpty() {
	        return size == 0;
	    }
	    private void ensureCapacity() {
	        if (elements.length == size)
	            elements = Arrays.copyOf(elements, 2 * size + 1);
	    }	
	    
	    @Override public CloneStack clone() {
	        try {
	        	CloneStack result = (CloneStack) super.clone();
	           result.elements = elements.clone();
	            return result;
	        } catch (CloneNotSupportedException e) {
	            throw new AssertionError();
	        }
	    }	    
	
	public static void main(String[] args) {
		CloneStack stack = new CloneStack();
        for (String arg : args)
            stack.push(arg);
        
        CloneStack copy = stack.clone();
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();
        while (!copy.isEmpty())
            System.out.print(copy.pop() + " ");
	}

	private void iterateArray() {
        for (int i = 0; i <elements.length; i++) {
			System.out.println(elements[i]);
		}
	}
}
