package hashing;

import java.util.HashMap;
import java.util.Map;

// Given an array with 0s and 1s. Find the longest sub array with equal no. of 0s and 1s.
public class LongestSubarrayEqual01s {

	public static void main(String[] args) {
		int[] arr = { 1, 0, 1, 1, 1, 0, 0 }; // O/P: 6
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				arr[i] = -1;
		}
		Map<Integer, Integer> sumLen = new HashMap<>();
		int preSum = 0, maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			preSum += arr[i];
			if (preSum == 0)
				maxLen = i + 1;
			boolean hasPreSum = sumLen.containsKey(preSum);
			if (hasPreSum)
				maxLen = Math.max(maxLen, i - sumLen.get(preSum));
			else
				sumLen.put(preSum, i);
		}
		System.out.println(maxLen);
	}
	
}
