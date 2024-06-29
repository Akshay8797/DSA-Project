package searching.binarySearch;

import utils.MathUtils;

// Given a sorted array and a no. x, find the index of the last occurrence of x. 
public class LastOccurrenceIndex {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 20, 20, 40, 40 };
		System.out.println(getLastOccurrenceIndex(arr, 20));
	}

	// T(n): O(log n)
	protected static int getLastOccurrenceIndex(int[] arr, int x) {
		int n = arr.length, low = 0, high = n - 1;
		while (low <= high) {
			int mid = MathUtils.getMidpoint(low, high);
			if (arr[mid] > x)
				high = mid - 1;
			else if (arr[mid] < x)
				low = mid + 1;
			else {
				if (mid == n - 1 || arr[mid + 1] != arr[mid])
					return mid;
				low = mid + 1;
			}
		}
		return -1;
	}

}
