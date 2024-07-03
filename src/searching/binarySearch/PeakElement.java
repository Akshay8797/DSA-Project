package searching.binarySearch;

import utils.MathUtils;

// Given an unsorted array. Find a peak element (not smaller than its neighbors).
public class PeakElement {

	public static void main(String[] args) {
		int[] arr = { 5, 10, 20, 15, 7 };
		System.out.println(getPeakEff(arr));
	}

	// T(n): O(n)
	@SuppressWarnings("unused")
	private static int getPeakElement(int[] arr) {
		int n = arr.length;
		if (n == 1)
			return arr[0];
		if (arr[0] >= arr[1])
			return arr[0];
		if (arr[n - 1] >= arr[n - 2])
			return arr[n - 1];
		for (int i = 1; i < n - 1; i++) {
			if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1])
				return arr[i];
		}
		return -1;
	}

	/*- If the element to the left of mid is greater or equal to the mid, there is a peak on the left of mid.
	 * 	else there is a peak on the right (else mid would be a peak).
	 * 	T(n): O(log n)
	 */
	private static int getPeakEff(int[] arr) {
		int n = arr.length, low = 0, high = n - 1;
		while (low <= high) {
			int mid = MathUtils.getMidpoint(low, high);
			// check if mid is a peak.
			if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == n - 1 || arr[mid] >= arr[mid + 1]))
				return arr[mid];
			// Goto left as an independent array else goto right.
			if (mid > 0 && arr[mid - 1] >= arr[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1; // every array has a peak, so this won't execute.
	}

}
