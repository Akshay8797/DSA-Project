package sorting;

import java.util.Arrays;

/*- In-place and stable. Suitable for small sized arrays.
 *	T(n): O(n^2)
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 20, 5, 40, 60, 10, 30 };
		doInsertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void doInsertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

}
