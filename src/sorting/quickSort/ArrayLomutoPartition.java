package sorting.quickSort;

import java.util.Arrays;

import utils.ArrayUtils;

public class ArrayLomutoPartition {

	public static void main(String[] args) {
		int[] arr = { 10, 80, 30, 90, 40, 50, 70 };
		int pivotIndex = lPartition(arr, 0, 6);
		System.out.println("Pivot Index: " + pivotIndex);
		System.out.println("After Partition: " + Arrays.toString(arr));
	}

	/*- T(n): O(n), S(n): O(1). 
	 * 	After the partition, pivot is at its correct place.
	 */
	public static int lPartition(int[] arr, int l, int h) {
		int pivot = arr[h]; // pivot is the last element
		int i = l - 1;
		for (int j = l; j < h - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				ArrayUtils.swap(arr, i, j);
			}
		}
		ArrayUtils.swap(arr, i + 1, h);
		return (i + 1);
	}
}
