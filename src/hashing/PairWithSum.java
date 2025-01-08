package hashing;

import java.util.HashSet;
import java.util.Set;

/*- Given an array (can have duplicates or -ves).
 * 	Find if there is a pair with the given sum.
 */
public class PairWithSum {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 8, 15, -8 };
		int sum = 17;
		System.out.println(IsPairExistWithSum(arr, sum));
	}

	// T(n): O(n), S(n): O(n).
	private static boolean IsPairExistWithSum(int[] arr, int sum) {
		Set<Integer> nums = new HashSet<>();
		for (int x : arr) {
			if (nums.contains(sum - x))
				return true;
			else
				nums.add(x);
		}
		return false;
	}

}
