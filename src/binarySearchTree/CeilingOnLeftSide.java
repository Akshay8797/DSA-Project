package binarySearchTree;

import java.util.Arrays;
import java.util.TreeSet;

/*- Given an array, for every element find the ceiling for it on the left side.
 * 	Ceiling: Equal or closest greater value.
 * 	{30, 20, 10} => {-1, 30, 20}
 */
public class CeilingOnLeftSide {

	public static void main(String[] args) {
		int[] nums = { 2, 8, 30, 15, 25, 12 };
		int[] ceils = getLeftCeilings(nums);
		System.out.println(Arrays.toString(ceils));
	}

	// T(n): O(n * log n), S(n): O(n).
	private static int[] getLeftCeilings(int[] arr) {
		int n = arr.length, res[] = new int[n];
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			Integer ceil = set.ceiling(arr[i]);
			if (ceil != null)
				res[i] = ceil;
			else
				res[i] = -1;
			set.add(arr[i]);
		}
		return res;
	}

}
