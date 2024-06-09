package arrays;

public class MaximumCircularSubArraySum {

	public static void main(String[] args) {
		int[] arr = { -5, -2, -3, -4 };
		System.out.println(getMaxCircularSubArrayEff(arr));
	}

	// T(n): O(n^2)
	@SuppressWarnings("unused")
	private static int getMaxCircularSubArraySum(int[] arr) {
		int n = arr.length, res = arr[0];
		for (int i = 0; i < n; i++) {
			int currSum = arr[i], currMax = arr[i];
			for (int j = 1; j < n; j++) {
				currSum += arr[(i + j) % n];
				currMax = Math.max(currMax, currSum);
			}
			res = Math.max(res, currMax);
		}
		return res;
	}

	/*- Max of: Maximum normal sub-array Sum and,
	 * 	Maximum circular sub-array sum (Use modified Kadane's algorithm to find minimum sub-array sum,
	 * 	and subtract from total array sum to get the maximum circular sub-array sum). 
	*/
	private static int getMaxCircularSubArrayEff(int[] arr) {
		int maxNormalSum = MaximumSubArraySum.getMaxSubArraySumEff(arr);
		if (maxNormalSum < 0)
			return maxNormalSum;
		int arrSum = 0;
		for (int i = 0; i < arr.length; i++) {
			arrSum += arr[i];
			arr[i] = -arr[i];
		}
		// Maximum sub-array sum in the inverted array, is the inverted minimum sub-array sum.
		int maxCircularSum = arrSum + MaximumSubArraySum.getMaxSubArraySumEff(arr);
		return Math.max(maxNormalSum, maxCircularSum);
	}

	/*- Alternative approach:
	 * private static int maxCircularSum(int[] arr) {
	`*	int n = arr.length, minVal = 0, minIndex = -1, res;
	`*	for (int i = 0; i < n; i++) {
	`*		if (arr[i] < minVal) {
	`*			minVal = arr[i];
	 *			minIndex = i;
	 *		}
	 *	}
	 *	if (minIndex != -1) {
	 *		int maxEnding = arr[(minIndex + 1) % n];
	 *		res = arr[(minIndex + 1) % n];
	 *		for (int i = 2; i < n; i++) {
	 *			index = (minIndex + i) % n;
	 *			maxEnding = Math.max(maxEnding + arr[index], arr[index]);
	 *			res = Math.max(res, maxEnding);
	 *		}
	 *	} else
	 *		res = Arrays.stream(arr).sum();
	 *	return res;
	 * } 
	 */

}
