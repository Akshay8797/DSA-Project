package sorting;

import java.util.Arrays;

import utils.ArrayUtils;

/*- In-place sorting with less memory writes.
 * 	Selection sort is unstable [90, 80, 90, 25].
 * 	T(n): O(n^2).
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 10, 5, 8, 20, 2, 18 };
		doSelectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void doSelectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex])
					minIndex = j;
			}
			if (minIndex != i)
				ArrayUtils.swap(arr, i, minIndex);
		}
	}

}
