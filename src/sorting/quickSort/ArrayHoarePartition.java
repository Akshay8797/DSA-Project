package sorting.quickSort;

import java.util.Arrays;

import utils.ArrayUtils;

public class ArrayHoarePartition {

	public static void main(String[] args) {
		int[] arr = { 5, 3, 8, 4, 2, 7, 1, 10 };
		int index = hPartition(arr, 0, arr.length - 1);
		System.out.println("Index: " + index);
		System.out.println("After Partition: " + Arrays.toString(arr));
	}

	/*- T(n): O(n), S(n): O(1).
	 * 	Performs better than Lomuto partition.
	 * 	Elements, el <= pivot are on the left-half and el >= pivot are on the right-half.
	 * 	Thus, pivot is not at the correct position as opposed to Lomudo partition.
	 */
	static int hPartition(int[] arr, int l, int h) {
		int pivot = arr[l]; // pivot is the first element
		int i = l - 1, j = h + 1;
		while (true) {
			do {
				i++;
			} while (arr[i] < pivot);
			do {
				j--;
			} while (arr[j] > pivot);
			if (i >= j)
				return j;
			ArrayUtils.swap(arr, i, j);
		}
	}

}
