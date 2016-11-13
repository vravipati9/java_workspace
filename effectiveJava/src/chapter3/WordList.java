package chapter3;
import java.math.BigDecimal;
import java.util.*;
public class WordList {

	public static void main(String[] args) {
		Set<BigDecimal> hashSet = new HashSet<BigDecimal>();
		Set<BigDecimal> treeSet = new TreeSet<BigDecimal>();
		//Collections.addAll(set, args);
		//System.out.println(set);
		
		BigDecimal bd1 = new BigDecimal("1.0");
		BigDecimal bd2 = new BigDecimal("1.00");
		
		Collections.addAll(hashSet, bd1, bd2);
		Collections.addAll(treeSet, bd1, bd2);
		System.out.println("HashSet:::"+hashSet);
		System.out.println("TreeSet:::"+treeSet);
	}
}
