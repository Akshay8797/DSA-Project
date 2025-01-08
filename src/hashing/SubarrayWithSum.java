package hashing;

import java.util.HashSet;
import java.util.Set;

/*- Given an array that might contain negatives and duplicates and a sum x,
 * 	Find if there is a sub-array sum x.
 */
public class SubarrayWithSum {

	public static void main(String[] args) {
		int[] arr = { 5, 8, 6, 13, 3, -1 };
		System.out.println(isSubarrWithSumPresent(arr, 22));
	}

	private static boolean isSubarrWithSumPresent(int[] arr, int x) {
		Set<Integer> sums = new HashSet<>();
		int preSum = 0;
		for (int i = 0; i < arr.length; i++) {
			preSum += arr[i];
			if (preSum == x)
				return true;
			if (sums.contains(preSum - x))
				return true;
			sums.add(preSum);
		}
		return false;
	}

}
