import java.util.Arrays;

public class InsertingElementsToArrays {

	public static void insertUnsortedArray(String toInsert) {

		String[] unsortedArray = { "A", "D", "C" };
		System.out.println(unsortedArray.length);
		String[] newUnsortedArray = new String[unsortedArray.length + 1];
		System.arraycopy(unsortedArray, 0, newUnsortedArray, 0, 3);
		newUnsortedArray[newUnsortedArray.length - 1] = toInsert;
		System.out.println(Arrays.toString(newUnsortedArray));

	}

	public static void insertSortedArray(String toInsert) {

		String[] sortedArray = { "A", "C", "D" };

		/*
		 * Binary search returns the index of the search item if found,
		 * otherwise returns the minus insertion point. This example returns
		 * index = -2, which means the elemnt is not found and needs to be
		 * inserted as a second element.
		 */
		int index = Arrays.binarySearch(sortedArray, toInsert);

		if (index < 0) { // not found.

			// array indices are zero based. -2 index means insertion point of
			// -(-2)-1 = 1, so insertIndex = 1
			int insertIndex = -index - 1;

			String[] newSortedArray = new String[sortedArray.length + 1];
			System.arraycopy(sortedArray, 0, newSortedArray, 0, insertIndex);
			System.arraycopy(sortedArray, insertIndex, newSortedArray,
					insertIndex + 1, sortedArray.length - insertIndex);
			System.out.println(Arrays.toString(newSortedArray));
			newSortedArray[insertIndex] = toInsert;
			System.out.println(Arrays.toString(newSortedArray));
		}
	}

	public static void main(String[] args) {
		insertUnsortedArray("B");
		insertSortedArray("B");
	}
}