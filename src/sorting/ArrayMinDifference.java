package sorting;

import java.util.Arrays;

// {1, 8, 12, 5, 18} => 8 - 5 => 3
public class ArrayMinDifference {

	public static void main(String[] args) {
		int[] arr = { 1, 8, 12, 5, 18 };
		System.out.println(getMinDifference(arr));
	}

	// T(n): O(n * log n), returns infinite when n is less than 2.
	private static int getMinDifference(int[] arr) {
		Arrays.sort(arr);
		int diff = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++)
			diff = Math.min(arr[i] - arr[i - 1], diff);
		return diff;
	}

}
