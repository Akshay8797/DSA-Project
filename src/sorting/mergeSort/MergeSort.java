package sorting.mergeSort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 10, 5, 30, 15, 7 };
		doMergeSort(arr, 0, 4);
		System.out.println(Arrays.toString(arr));
	}

	// T(n): O(n * log n), S(n): O(n)
	static void doMergeSort(int[] arr, int l, int r) {
		if (r > l) { // atleast 2 elements
			int mid = l + (r - l) / 2;
			doMergeSort(arr, l, mid);
			doMergeSort(arr, mid + 1, r);
			MergeOfMergeSort.merge(arr, l, mid, r);
		}
	}

}
