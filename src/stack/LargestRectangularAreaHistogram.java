package stack;

import utils.StackUtils;

/*- Given an int array, each value corresponds to height of the bar in a histogram.
 * 	Assuming width of each bar is 1. Find the largest rectangular area in the histogram.
 * 	Ex: [6,2,5,4,1,5,6] => 10 {Last 5+5}.
 */
public class LargestRectangularAreaHistogram {

	public static void main(String[] args) {
		int[] arr = { 6, 2, 5, 4, 1, 5, 6 };
		System.out.println(getMaxAreaBetter(arr));
	}

	// Consider each element as the smallest bar, and find largest area using that.
	// T(n): O(n^2).
	static int getMaxAreaNaive(int[] arr) {
		int resArea = 0;
		for (int i = 0; i < arr.length; i++) {
			int currArea = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] >= arr[i])
					currArea += arr[i]; // Include arr[i] area for bars >= on the left.
				else
					break;
			}
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] >= arr[i])
					currArea += arr[i]; // Include arr[i] area for bars >= on the right.
				else
					break;
			}
			resArea = Math.max(resArea, currArea);
		}
		return resArea;
	}

	// Similar to naive, considering each bar as the smallest but using formula.
	// T(n): O(n), S(n): O(n).
	static int getMaxAreaBetter(int[] arr) {
		int n = arr.length, res = 0;
		if (n == 0)
			return 0;
		int[] prevSmallers = StackUtils.getPrevSmallerIndx(arr);
		int[] nextSmallers = StackUtils.getNextSmallerIndx(arr);
		for (int i = 0; i < n; i++) {
			int curr = arr[i];
			// Using formula to compute left and right area.
			curr += (i - prevSmallers[i] - 1) * arr[i];
			curr += (nextSmallers[i] - i - 1) * arr[i];
			res = Math.max(res, curr);
		}
		return res;
	}

}
