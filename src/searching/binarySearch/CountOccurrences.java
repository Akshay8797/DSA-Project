package searching.binarySearch;

public class CountOccurrences {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 20, 20, 30, 30 };
		System.out.println(getOccurencesCount(arr, 20));
	}

	// T(n): O(log n)
	private static int getOccurencesCount(int[] arr, int x) {
		int firstOccurence = FirstOccurrenceIndex.getFirstOccurrenceIndex(arr, x);
		if (firstOccurence == -1)
			return 0;
		return (LastOccurrenceIndex.getLastOccurrenceIndex(arr, x) - firstOccurence + 1);
	}

}
