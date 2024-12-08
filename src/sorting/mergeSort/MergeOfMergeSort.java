package sorting.mergeSort;

import java.util.Arrays;

/*- Given an array and indexes: low, mid, and high.
 * 	Elements from low to mid, and mid+1 to high are sorted.
 * 	WAP to sort the array from low to high. [low <= mid < high].
 */
public class MergeOfMergeSort {

	public static void main(String[] args) {
		int[] arr = { 10, 15, 20, 40, 8, 11, 55 };
		// low: 0, mid: 3, high: 6
		merge(arr, 0, 3, 6);
		System.out.println(Arrays.toString(arr));
	}

	// T(n): O(n), S(n): O(n)
	static void merge(int[] arr, int low, int mid, int high) {
		int n1 = mid - low + 1, n2 = high - mid;
		int left[] = new int[n1], right[] = new int[n2];
		for (int i = 0; i < n1; i++) {
			left[i] = arr[low + i];
		}
		for (int i = 0; i < n2; i++) {
			right[i] = arr[mid + 1 + i];
		}
		int i = 0, j = 0, k = low;
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
				k++;
			} else {
				arr[k] = right[j];
				j++;
				k++;
			}
		}
		while (i < n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}

}
