import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetDemo {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(3, 2, 4, 1, 5);
    NavigableSet<Integer> ns = new TreeSet<Integer>(list);
    System.out.println("Ascending order (default): " + ns);

    Iterator<Integer> descendingIterator = ns.descendingIterator();
    
    StringBuilder sb = new StringBuilder("Descending order: ");
    while (descendingIterator.hasNext()) {
      int m = descendingIterator.next();
      sb.append(m + " ");
    }
    System.out.println(sb);

    int greatest = ns.lower(3);
    int greatest1 = ns.floor(3);
    System.out.println("Lower of 3 = " + greatest);
    System.out.println("Lower of 3 = " + greatest1);

    int smallest = ns.higher(3);
    System.out.println("Higher of 3 = " + smallest);
  }
}