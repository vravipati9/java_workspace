package chapter5;

// List-based generic reduction - Page 123

import java.util.*;

public class Reduction {

	// Correct way
	/*
	 *  lists can both consume and produce values, the reduce method uses its
		list parameter only as an E producer, so its declaration should use a wildcard
		type that extends E. The parameter f represents a function that both consumes
		and produces E instances, so a wildcard type would be inappropriate for it

		 List<? extends E> list, this wild card notation is required if you have a List<Integer>, and you want to reduce it with a
		 Function<Number>.
	 */
	static <E> E reduce(List<? extends E> list, Function<E> f, E initVal) {
        List<E> snapshot;
        synchronized(list) {
            snapshot = new ArrayList<E>(list);
        }
        E result = initVal;
        for (E e : snapshot)
            result = f.apply(result, e);
        return result;
    }

    // Wrong way to implement reduce method, becoz it is trying to convert Generic List to Generic Array and 
    // what type of E is not availabe at runtime for array creation, 
    // With out doing the typecasting (E[]) the code will fail and  now it give warning
    static <E> E reduce1(List<E> list, Function<E> f, E initVal) {
    	E[] snapshot = (E[])list.toArray(); // Locks list
    	E result = initVal;
    	for (E e : snapshot)
    		result = f.apply(result, e);
    	return result;
    }

    // A few sample functions

    private static final Function<Integer> SUM = new Function<Integer>(){
        public Integer apply(Integer i1, Integer i2) {
            return i1 + i2;
        }
    };

    private static final Function<String> SUM_STRING = new Function<String>(){
        public String apply(String i1, String i2) {
            return i1.concat(i2);
        }
    };
    private static final Function<Integer> PRODUCT = new Function<Integer>(){
        public Integer apply(Integer i1, Integer i2) {
            return i1 * i2;
        }
    };


    private static final Function<Integer> MAX = new Function<Integer>(){
        public Integer apply(Integer i1, Integer i2) {
            return Math.max(i1, i2);
        }
    };

    private static final Function<Number> MAX_NUMBER = new Function<Number>(){
        public Number apply(Number n1, Number n2) {
        	return Double.compare(n1.doubleValue(), n2.doubleValue()) > 0 ? n1 : n2;
        }
    };

    private static final Function<Integer> MIN = new Function<Integer>(){
        public Integer apply(Integer i1, Integer i2) {
            return Math.min(i1, i2);
        }
    };

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(
            2, 7, 1, 8, 2, 8, 1, 8, 2, 8);
        // Reduce intList using each of the above reducers
        System.out.println(reduce(intList, SUM, 0));
        System.out.println(reduce(intList, PRODUCT, 1));
        System.out.println(reduce(intList, MAX, Integer.MIN_VALUE));
        System.out.println(reduce(intList, MIN, Integer.MAX_VALUE));
        
        System.out.println(reduce(intList, MAX_NUMBER, Double.MIN_VALUE));
        
        System.out.println(reduce1(Arrays.asList("A", "B"), SUM_STRING, ""));
    }
}
