package sorting;

import java.util.Arrays;

/*- Given arr with elements in range 0 to k-1 (where k is linear).
 * 	Counting sort is not comparison based, it counts the occurrences.
 * 	It is used as a subroutine in radix sort.
 */
public class CountingSort {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 4, 4, 1, 0, 1 };
		countingSort(arr, 5);
		System.out.println(Arrays.toString(arr));
	}

	// T(n): O(n+k). Cannot be used for Objects.
	static void doCountingSort(int[] arr, int k) {
		int[] occr = new int[k];
		for (int i = 0; i < arr.length; i++) {
			occr[arr[i]]++;
		}
		int idx = 0;
		for (int i = 0; i < occr.length; i++) {
			for (int j = 0; j < occr[i]; j++) {
				arr[idx] = i;
				idx++;
			}
		}
	}

	// T(n): O(n+k), S(n): O(n+k). General purpose and stable.
	private static void countingSort(int arr[], int k) {
		int count[] = new int[k], n = arr.length;
		for (int i = 0; i < n; i++) {
			count[arr[i]]++;
		}
		for (int i = 1; i < k; i++) {
			count[i] = count[i - 1] + count[i];
		}
		int[] output = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		System.arraycopy(output, 0, arr, 0, n);
	}

}
