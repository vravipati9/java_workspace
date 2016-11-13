package amplex;

public class FindMissingNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//private static int getMissingNumber(int[] numbers, int totalCount) { int expectedSum = totalCount * ((totalCount + 1) / 2); int actualSum = 0; for (int i : numbers) { actualSum += i; } return expectedSum - actualSum; }

//Read more: http://javarevisited.blogspot.com/2014/11/how-to-find-missing-number-on-integer-array-java.html#ixzz3KXQ2e5U4
	
	//private static void printMissingNumber(int[] numbers, int count) { int missingCount = count - numbers.length; BitSet bitSet = new BitSet(count); for (int number : numbers) { bitSet.set(number - 1); } System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers), count); int lastMissingIndex = 0; for (int i = 0; i < missingCount; i++) { lastMissingIndex = bitSet.nextClearBit(lastMissingIndex); System.out.println(++lastMissingIndex); } }

//Read more: http://javarevisited.blogspot.com/2014/11/how-to-find-missing-number-on-integer-array-java.html#ixzz3KXQIzAof