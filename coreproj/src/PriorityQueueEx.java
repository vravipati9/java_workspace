import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import static java.lang.System.out;
import java.lang.Number;
public class PriorityQueueEx {
	static class PQsort implements Comparator<Integer> { // inverse sort
		public int compare(Integer one, Integer two) {
			return two - one; // unboxing
		}
	}

	public static void main(String[] args) {
		int[] ia = { 1, 5, 3, 7, 6, 9, 8 }; // unordered data
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(); // use
																	// natural
																	// order
		for (int x : ia) // load queue
			pq1.offer(x);
		//pq1.add(50);
		System.out.println("OriginalList   :"+pq1);
		for (int x : ia)
			System.out.print(pq1.poll() + " ");

		System.out.println("");
		PQsort pqs = new PQsort(); // get a Comparator
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, pqs); // use
																			// Comparator
		for (int x : ia)
			pq2.offer(x);

		System.out.println("After Comparator   "+pq2);
		System.out.println("size " + pq2.size());
		System.out.println("peek " + pq2.peek());
		System.out.println("size " + pq2.size());
		System.out.println("poll " + pq2.poll());
		System.out.println("size " + pq2.size());
		for (int x : ia)
			System.out.print(pq2.poll() + " ");
		
		System.out.println("-------Another Ex----------");
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("banana");
		pq.add("pear");
		pq.add("apple");
		System.out.println("Original List   "+pq + " ");
		System.out.println(pq.poll() + "POLL ");
		System.out.println(pq);
		//System.out.println(pq.poll() + " " + pq.peek());
	}
}