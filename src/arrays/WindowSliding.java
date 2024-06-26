package arrays;

import utils.ArrayUtils;

public class WindowSliding {

	public static void main(String[] args) {
		int[] arr = { 1, 8, 30, -5, 20, 7 };
		System.out.println(getMaxSumOfKElem(arr, 3));
	}

	// Gets the maximum sum of k consecutive elements
	private static int getMaxSumOfKElem(int[] arr, int k) {
		int n = arr.length;
		if (k <= 0 || k > n)
			return -1;
		int sum = ArrayUtils.getArraySumFromToIndex(arr, 0, k), maxSum = sum;
		for (int i = k; i < n; i++) {
			sum = sum + arr[i] - arr[i - k];
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

}
