package sorting;

import java.util.Arrays;

/*- Used when the range of nos. is greater than linear.
 * 	It is stable and uses Counting sort as a subroutine.
 */
public class RadixSort {

	public static void main(String[] args) {
		int[] arr = { 319, 212, 6, 8, 100, 50 };
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	// T(n): O(d*n) - Where d is the no. digits in the max element.
	private static void radixSort(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(arr[i], max);
		}
		// Do Counting sort for all digits
		for (int e = 1; max / e > 0; e *= 10) {
			countingSort(arr, e);
		}
	}

	private static void countingSort(int[] arr, int e) {
		int count[] = new int[10], n = arr.length;
		for (int i = 0; i < n; i++) {
			int digit = (arr[i] / e) % 10;
			count[digit]++;
		}
		for (int i = 1; i < 10; i++) {
			count[i] = count[i - 1] + count[i];
		}
		int[] output = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			int digit = (arr[i] / e) % 10;
			output[count[digit] - 1] = arr[i];
			count[digit]--;
		}
		System.arraycopy(output, 0, arr, 0, n);
	}

}
