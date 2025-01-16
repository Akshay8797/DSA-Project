package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*- Given an array, find the length of the longest consecutive subsequence.
 * 	where elements are in the form of x, x+1, x+2, ..., x+i in any order.
 * 	Ex: [1, 9, 3, 4, 2, 20] => 4 (1, 3, 4, 2).
 */
public class LongestConsSubsequence {

	public static void main(String[] args) {
		int[] arr = { 1, 9, 3, 4, 2, 20 };
		System.out.println(getLongestConSeq(arr));
	}

	// T(n): O(n * log n).
	static int getLongestConSeq(int[] arr) {
		if (arr.length == 0)
			return 0;
		Arrays.sort(arr);
		int len = 1, maxLen = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1] + 1)
				len++;
			else if (arr[i] != arr[i - 1]) { // skip duplicates
				maxLen = Math.max(len, maxLen);
				len = 1;
			}
		}
		return Math.max(len, maxLen);
	}

	// T(n): O(n).
	static int getLongestConSeqEff(int[] arr) {
		if (arr.length == 0)
			return 0;
		Set<Integer> subs = new HashSet<>();
		for (int x : arr)
			subs.add(x);
		int maxLen = 1;
		for (Integer x : subs) {
			if (!subs.contains(x - 1)) {
				int len = 1;
				while (subs.contains(x + len))
					len++;
				maxLen = Math.max(len, maxLen);
			}
		}
		return maxLen;
	}

}
