package sorting;

import java.util.Arrays;

import sorting.quickSort.ArrayLomutoPartition;
import sorting.quickSort.QuickSort;

/*- Given an array of size n with an int k <= n.
 * 	Find kth smallest element in the array.
 * 	arr[]: {30, 20, 5, 10, 8}, k: 4 => 20
 */
public class KthSmallestElement {

	public static void main(String[] args) {
		int[] arr = { 30, 20, 5, 10, 8 };
		System.out.println(getKthSmallestEff(arr, 4));
	}

	// T(n): O(n * log n)
	static int getKthSmallest(int[] arr, int k) {
		Arrays.sort(arr);
		return arr[k - 1];
	}

	// Quick select algorithm. T(n): O(n*log n), but works better than sort in general.
	private static int getKthSmallestEff(int[] arr, int k) {
		int low = 0, high = arr.length - 1;
		while (low < high) {
			QuickSort.randomizePivot(arr, low, high, 'l');
			int pivotIndex = ArrayLomutoPartition.lPartition(arr, low, high);
			if (pivotIndex == k - 1)
				return pivotIndex;
			else if (pivotIndex > k - 1)
				high = pivotIndex - 1;
			else
				low = pivotIndex + 1;
		}
		return -1;
	}

}
