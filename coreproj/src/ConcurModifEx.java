import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/*
 * The java.util Collection classes are fail-fast, which means that if one thread changes a collection while another
   thread is traversing it through with an iterator the iterator.hasNext() or iterator.next() call will throw
   ConcurrentModificationException. 
   
   Even the synchronized collection wrapper classes SynchronizedMap and SynchronizedList are only conditionally thread-safe,
   which means all individual operations are thread-safe but compound operations where flow of control depends on the results
   of previous operations may be subject to threading issues.
 */
public class ConcurModifEx {

	public static void main(String[] args) {
		List<String> myCollection = new ArrayList<String>();
		final int i = 12;
		
		myCollection.add("123");
		myCollection.add("456");
		myCollection.add("789");
		CopyOnWriteArrayList<String> newObj = new CopyOnWriteArrayList<String>();
		//ConcurrentHashMap
		
		newObj.addAll(myCollection);
		
		for (Iterator it = newObj.iterator(); it.hasNext();) {
			String myObject = (String) it.next();
			System.out.println(myObject);
			if (true) {
				newObj.remove(myObject);
			}
		}
		System.out.println("After remove..."+newObj);
		
		for (Iterator it = myCollection.iterator(); it.hasNext();) {
			String myObject = (String) it.next();
			System.out.println(myObject);
			if (true) {
				//myCollection.remove(myObject); // can throw ConcurrentModificationException exception
				//it.remove();
			}
		}
		
		String s1 = new String("A"); //not recommended, use String s1 = "A"
		String s2 = new String("A"); //not recommended, use String s2 = "A"
		
		System.out.println(s1 == s2);
		System.out.println(s1.intern() == s2.intern());

	}

}
