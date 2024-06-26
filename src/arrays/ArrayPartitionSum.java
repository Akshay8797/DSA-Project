package arrays;

import utils.ArrayUtils;

/*- Given an array, check if it can be partitioned into 3 parts with equal sum.
 * `I/P: [5,2,6,1,1,1,1,4]	=>	O/P: True (5+2 = 6+1 = 1+1+1+1+4).
 */
public class ArrayPartitionSum {

	public static void main(String[] args) {
		int[] arr = { 5, 2, 6, 1, 1, 1, 1, 4 };
		System.out.println(isThreePartitionSum(arr));
	}

	private static boolean isThreePartitionSum(int[] arr) {
		int n = arr.length, left = 0, right = n - 1, lSum = arr[0], rSum = arr[n - 1],
				midSum = ArrayUtils.getArraySumFromToIndex(arr, 1, n - 1);
		while (left < right) {
			if (lSum == rSum && lSum == midSum)
				return true;
			if (lSum > rSum) {
				--right;
				rSum += arr[right];
				midSum -= arr[right];
			} else {
				++left;
				lSum += arr[left];
				midSum -= arr[left];
			}
		}
		return false;
	}

}
