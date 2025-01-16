package hashing;

/*- Given 2 binary arrays of same size. Find the length of the longest common sub-array.
 * 	Where, start and end index of the sub-arrays should be same in both the arrays.
 * 	Also, sum of the sub-arrays in both the arrays should be same.
 *	I/p: [0, 1, 0, 0, 0, 0], [1, 0, 1, 0, 0, 1] => O/p: 4 (From index 1 to 4).
 */
public class LongestComnSubarrWithSum {

	public static void main(String[] args) {
		int[] a = { 0, 1, 0, 0, 0, 0 }, b = { 1, 0, 1, 0, 0, 1 };
		System.out.println(getLongestComnSubarrSumEff(a, b));
	}

	// T(n): O(n^2)
	static int getLongestComnSubarrSum(int[] a, int[] b) {
		int n = a.length, maxLen = 0;
		for (int i = 0; i < n; i++) {
			int s1 = a[i], s2 = b[i];
			for (int j = i + 1; j < n; j++) {
				s1 += a[j];
				s2 += b[j];
				if (s1 == s2)
					maxLen = Math.max(maxLen, j);
			}
		}
		return maxLen;
	}

	// T(n): O(n), S(n): O(n)
	static int getLongestComnSubarrSumEff(int[] a, int[] b) {
		int n = a.length, diffArr[] = new int[n];
		for (int i = 0; i < n; i++) {
			diffArr[i] = a[i] - b[i];
		}
		return LongestSubarrayEqual01s.getLongestSubarrWith0Sum(diffArr);
	}

}
