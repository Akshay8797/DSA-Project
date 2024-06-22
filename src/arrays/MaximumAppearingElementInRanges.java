package arrays;

/*- Given n ranges. Find the maximum appearing element in all the ranges.
 * 	I/P: left = [1,2,5,15], right = [5,8,7,18]	=> O/P: 5 (1 to 5, 2 to 8, 5 to 7, 15 to 18).
 * 	Note: 0 <= left[i] <= right[i] < 100
 */
public class MaximumAppearingElementInRanges {

	private static final int rangeSize = 100;

	public static void main(String[] args) {
		int[] left = { 1, 2, 5, 15 };
		int[] right = { 5, 8, 7, 18 };
		System.out.println(getMaxInRangesEff(left, right));
	}

	// T(n): O(n * rangeSize)
	@SuppressWarnings("unused")
	private static int getMaxInRanges(int[] left, int[] right) {
		int[] freq = new int[rangeSize];
		for (int i = 0; i < left.length; i++) {
			for (int j = left[i]; j <= right[i]; j++)
				freq[j]++;
		}
		int res = 0;
		for (int i = 1; i < rangeSize; i++) {
			if (freq[i] > freq[res])
				res = i;
		}
		return res;
	}

	// T(n): O(n + rangeSize)
	private static int getMaxInRangesEff(int[] left, int[] right) {
		int[] freq = new int[rangeSize + 1]; // To handle: freq[right[i]+1]--;
		for (int i = 0; i < left.length; i++) {
			freq[left[i]]++;
			freq[right[i] + 1]--;
		}
		// Building prefix sum and checking max
		int res = 0;
		for (int i = 1; i < rangeSize; i++) {
			freq[i] += freq[i - 1];
			if (freq[i] > freq[res])
				res = i;
		}
		return res;
	}

}
