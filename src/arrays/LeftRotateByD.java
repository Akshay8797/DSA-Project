package arrays;

import java.util.Arrays;

/*- Left rotate an array (counter clockwise) by D
 * 	I/P: arr[] = {1, 2, 3, 4, 5}, d=2.
 *	O/P: {3, 4, 5, 1, 2} 
 */
public class LeftRotateByD {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Arrays.stream(getLeftRotatedByDEff(arr, 2)).forEach(System.out::println);
	}

	@SuppressWarnings("unused")
	// T(n): O(n), S(n): O(d)
	private static int[] getLeftRotatedByD(int[] arr, int d) {
		int[] firstD = new int[d];
		int n = arr.length;
		System.arraycopy(arr, 0, firstD, 0, d);
		for (int i = d; i < n; i++) {
			arr[i - d] = arr[i];
		}
		System.arraycopy(firstD, 0, arr, n - d, d);
		return arr;
	}

	// T(n): O(n), S(n): O(1)
	private static int[] getLeftRotatedByDEff(int[] arr, int d) {
		int n = arr.length;
		ArrayUtils.reverse(arr, 0, d - 1);
		ArrayUtils.reverse(arr, d, n - 1);
		ArrayUtils.reverse(arr, 0, n - 1);
		return arr;
	}

}
