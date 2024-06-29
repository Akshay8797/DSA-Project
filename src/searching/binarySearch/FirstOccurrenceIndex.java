package searching.binarySearch;

import utils.MathUtils;

// Given a sorted array and a no. x, find the index of the first occurrence of x. 
public class FirstOccurrenceIndex {

	public static void main(String[] args) {
		int[] arr = { 1, 10, 10, 10, 20, 20, 40 };
		System.out.println(getFirstOccurrenceIndex(arr, 20));
	}

	// T(n): O(log n)
	protected static int getFirstOccurrenceIndex(int[] arr, int x) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = MathUtils.getMidpoint(low, high);
			if (arr[mid] > x)
				high = mid - 1;
			else if (arr[mid] < x)
				low = mid + 1;
			else {
				if (mid == 0 || arr[mid - 1] != arr[mid])
					return mid;
				high = mid - 1;
			}
		}
		return -1;
	}

}
