package arrays;

/*- Find the maximum value of arr[j] - arr[i], such that j > i.
 *  I/P: arr[] = {2, 3, 10, 6, 4, 8, 1}
 *  O/P: 8 (which is 10 - 2)
 */
public class MaximumDifference {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 10, 6, 4, 8, 1 };
		System.out.println(getMaxDiffWithOrderEff(arr));
	}

	// T(n): O(n^2)
	@SuppressWarnings("unused")
	private static int getMaxDiffWithOrder(int[] arr) {
		int maxDiff = arr[1] - arr[0], n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++)
				maxDiff = Integer.max(maxDiff, arr[j] - arr[i]);
		}
		return maxDiff;
	}

	// T(n): O(n)
	private static int getMaxDiffWithOrderEff(int[] arr) {
		int maxDiff = arr[1] - arr[0], minSoFar = arr[0];
		for (int j = 1; j < arr.length; j++) {
			maxDiff = Integer.max(maxDiff, arr[j] - minSoFar);
			minSoFar = Integer.min(minSoFar, arr[j]);
		}
		return maxDiff;
	}

}
