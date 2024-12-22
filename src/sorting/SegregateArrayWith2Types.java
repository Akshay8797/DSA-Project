package sorting;

import java.util.Arrays;

import utils.ArrayUtils;

/*- Given arr with 2 types: +ves and -ves, segregate the 2 types. 
 * 	Order within a type does not matter.
 */
public class SegregateArrayWith2Types {

	public static void main(String[] args) {
		int[] arr = { -5, 2, -7, -3, 4, 9 };
		segregate2T(arr);
		System.out.println(Arrays.toString(arr));
	}

	// T(n): O(n).
	private static void segregate2T(int[] arr) {
		int l = -1, h = arr.length;
		while (true) {
			do {
				l++;
			} while (l < arr.length - 1 && arr[l] < 0);
			do {
				h--;
			} while (h > 0 && arr[h] > 0);
			if (l >= h)
				return;
			ArrayUtils.swap(arr, l, h);
		}
	}

}
