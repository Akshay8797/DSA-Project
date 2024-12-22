package sorting;

import java.util.Arrays;

import utils.ArrayUtils;

/*- Given arr with 3 types: 0s, 1s and 2s, segregate the 3 types. 
 * 	Order within a type does not matter.
 */
public class SegregateArrayWith3Types {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 2, 1, 2 };
		segregateEff(arr);
		System.out.println(Arrays.toString(arr));
	}

	static void segregate3T(int[] arr) {
		int j = arr.length;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == 2) {
				j--;
				ArrayUtils.swap(arr, i, j);
			}
		}
		int l = 0, r = j;
		while (true) {
			do {
				l++;
			} while (l < j - 1 && arr[l] == 0);
			do {
				r--;
			} while (r > 0 && arr[r] == 1);
			if (l >= r)
				return;
			ArrayUtils.swap(arr, l, r);
		}
	}

	// Dutch National Flag Algo
	private static void segregateEff(int[] arr) {
		int lo = 0, hi = arr.length - 1, mid = 0;
		while (mid <= hi) {
			if (arr[mid] == 0) {
				ArrayUtils.swap(arr, lo, mid);
				lo++;
				mid++;
			} else if (arr[mid] == 1)
				mid++;
			else {
				ArrayUtils.swap(arr, hi, mid);
				hi--;
			}
		}
	}
}
