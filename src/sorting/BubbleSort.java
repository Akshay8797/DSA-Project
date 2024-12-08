package sorting;

import java.util.Arrays;

import utils.ArrayUtils;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 10, 8, 20, 5 };
		doBubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	// T(n): O(n^2)
	private static void doBubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < n - 1 - i; j++) { // as n-1-i is already sorted.
				if (arr[j] > arr[j + 1]) {
					ArrayUtils.swap(arr, j, j + 1);
					swapped = true;
				}
			}
			if (!swapped)
				break;
		}
	}

}
