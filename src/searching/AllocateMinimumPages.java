package searching;

import utils.ArrayUtils;
import utils.MathUtils;

/*- Given pages in n books (arr[] with length n) and student(s) k.
 * 	Find the minimum pages that can be read by a student so that all n books are read. 
 * 	Constraint: A student can only read contiguous books.
 * 	Ex. I/P: arr[] = {10, 20, 30, 40}, k = 2 => O/P: 60
 */
public class AllocateMinimumPages {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 10, 40 };
		System.out.println(getMinPagesEff(arr, 2));
	}

	// T(n): O(n² × k), S(n): O(k)
	@SuppressWarnings("unused")
	private static int getMinPages(int[] arr, int n, int k) {
		if (k == 1)
			return ArrayUtils.getArraySumIncl(arr, 0, n - 1);
		if (n == 1)
			return arr[0];
		int res = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			// Recursively find the minimum of the maximum pages a student reads
			int currRes = Math.max(getMinPages(arr, i, k - 1), ArrayUtils.getArraySumIncl(arr, i, n - 1));
			res = Math.min(res, currRes);
		}
		return res;
	}

	// T(n): O(n × log(sum))
	private static int getMinPagesEff(int arr[], int k) {
		int n = arr.length, sum = 0, max = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			max = Math.max(max, arr[i]);
		}
		int low = max, high = sum, res = 0;
		while (low <= high) {
			int mid = MathUtils.getMidpoint(low, high);
			// If feasible go to the left half else to the right half
			if (MathUtils.isFeasible(arr, k, mid)) {
				res = mid;
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return res;
	}

}
