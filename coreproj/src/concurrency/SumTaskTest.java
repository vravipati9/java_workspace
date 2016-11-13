package concurrency;


public class SumTaskTest {

	 public static void main(String[] args) {
	  int numberOfCpuCores = Runtime.getRuntime().availableProcessors();
	  //ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfCpuCores);

	  Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	  //int sum = forkJoinPool.invoke(new SumTask(numbers, 0, numbers.length));
	  //System.out.println(sum);
	  System.out.println("---"+numberOfCpuCores);
	 }

	}