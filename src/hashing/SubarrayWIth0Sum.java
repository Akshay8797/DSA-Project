package hashing;

import java.util.HashSet;
import java.util.Set;

// Note: Arr might have negatives and duplicates
public class SubarrayWIth0Sum {

	public static void main(String[] args) {
		int[] arr = { -1, 4, -3, 5, 1 };
		System.out.println(Is0SumSubarrPresent(arr));
	}

	// T(n): O(n), S(n): O(n).
	private static boolean Is0SumSubarrPresent(int[] arr) {
		Set<Integer> sums = new HashSet<>();
		int preSum = 0;
		for (int i = 0; i < arr.length; i++) {
			preSum += arr[i];
			if (sums.contains(preSum))
				return true;
			// To handle prefix with sum 0 in arr.
			if (preSum == 0)
				return true;
			sums.add(preSum);
		}
		return false;
	}

}
