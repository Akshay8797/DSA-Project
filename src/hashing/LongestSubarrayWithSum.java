package hashing;

import java.util.HashMap;
import java.util.Map;

/*- Given an array that might contain negatives and duplicates and a sum x,
 * 	Find the longest sub-array that exists with sum x.
 */
public class LongestSubarrayWithSum {

	public static void main(String[] args) {
		int[] arr = { 8, 3, 1, 5, -6, 6, 2, 2 };
		System.out.println(getMaxLenSubarr(arr, 4));
	}

	private static int getMaxLenSubarr(int[] arr, int x) {
		Map<Integer, Integer> sumLens = new HashMap<>();
		int preSum = 0, maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			preSum += arr[i];
			if (preSum == x)
				maxLen = i + 1;
			if (!sumLens.containsKey(preSum))
				sumLens.put(preSum, i);
			if (sumLens.containsKey(preSum - x))
				maxLen = Math.max(maxLen, i - sumLens.get(preSum - x));
		}
		return maxLen;
	}

}
