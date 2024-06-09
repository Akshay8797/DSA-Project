package arrays;

// Given an array, find the maximum sum of a sub-array (contiguous elements) from the array.
public class MaximumSubArraySum {

	public static void main(String[] args) {
		int[] arr = { 2, 3, -8, 7, -1, 2, 3 };
		System.out.println(getMaxSubArraySumEff(arr));
	}

	// T(n): O(n^2)
	@SuppressWarnings("unused")
	private static int getMaxSubArraySum(int[] arr) {
		int maxSum = arr[0], n = arr.length;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				maxSum = Math.max(maxSum, sum);
			}
		}
		return maxSum;
	}

	// Kadane's algorithm
	public static int getMaxSubArraySumEff(int[] arr) {
		int n = arr.length, res = arr[0], maxEnding = arr[0];
		for (int i = 1; i < n; i++) {
			maxEnding = Math.max(maxEnding + arr[i], arr[i]);
			res = Math.max(res, maxEnding);
		}
		return res;
	}

}
