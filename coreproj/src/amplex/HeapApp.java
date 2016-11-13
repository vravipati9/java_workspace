package amplex;

import java.util.Scanner;


public class HeapApp {
	public static void main(String a[]) {
		Heap<Integer> heap = new Heap<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter next int, 'done' to stop");
		String line = sc.next();
		while (!line.equals("done")) {
			heap.insert(Integer.valueOf(line));
			System.out.println(heap);
			System.out.println("Enter next int, 'done' to stop");
			line = sc.next();
		}
		while (!heap.isEmpty()) {
			int max = heap.delete();
			System.out.println(max+"       "+heap);
		}
	}
}
