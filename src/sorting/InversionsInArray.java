package sorting;

import utils.MathUtils;

/*- Given an array arr, count the no. of inversions.
 * 	Pair (arr[i], arr[j]) forms an inversion when i < j and arr[i] > arr[j].
 * 	Ex: [2, 4, 1, 3, 5]  => 3
 * 		[10, 20, 30, 40] => 0
 * 		[40, 30, 20, 10] => 6
 */

public class InversionsInArray {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 1, 3, 5 };
		System.out.println(countInv(arr, 0, 4));
	}

	// T(n): O(n^2)
	@SuppressWarnings("unused")
	private static int countInversions(int[] arr) {
		int n = arr.length, count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] > arr[j])
					count++;
			}
		}
		return count;
	}

	// T(n): O(n * logn), S(n): O(n)
	private static int countInv(int[] arr, int l, int r) {
		int res = 0;
		if (l < r) {
			int m = MathUtils.getMidpoint(l, r);
			// Count inversions in the left-right half, and the split inversions.
			res += countInv(arr, l, m);
			res += countInv(arr, m + 1, r);
			res += countAndMerge(arr, l, m, r);
		}
		return res;
	}

	private static int countAndMerge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1, n2 = r - m;
		int left[] = new int[n1], right[] = new int[n2];
		for (int i = 0; i < n1; i++)
			left[i] = arr[l + i];
		for (int i = 0; i < n2; i++)
			right[i] = arr[m + 1 + i];
		int res = 0, i = 0, j = 0, k = l;
		while (i < n1 && j < n2) {
			if (left[i] <= right[j])
				arr[k++] = left[i++];
			else {
				arr[k++] = right[j++];
				res += n1 - i;
			}
		}
		// Fill the remaining array with proper values.
		while (i < n1)
			arr[k++] = left[i++];
		while (j < n2)
			arr[k++] = right[j++];
		return res;
	}

}
