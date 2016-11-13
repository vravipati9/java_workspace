package chapter5;
import java.util.*;
public class NumOfElemntsCommInTwoSets {
	public static void main(String[] args) {
		Set s1 = new HashSet();
		Set s2 = new HashSet();
		s1.add(5);s1.add(3);s1.add(7);s1.add(2);s1.add(2);
		s2.add(5);s2.add(5);s2.add(6);
		System.out.println(numElementsInCommon(s1, s2));
	}
	private static int numElementsInCommon(Set s1, Set s2) {
		int count = 0;
		for (Object object : s2) {
			if (s1.contains(object)) {
				count++;
			}
		}
		return count;
	}
}
