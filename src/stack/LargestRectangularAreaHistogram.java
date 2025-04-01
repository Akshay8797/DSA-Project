package stack;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.StackUtils;

/*- Given an int array, each value corresponds to height of the bar in a histogram.
 * 	Assuming width of each bar is 1. Find the largest rectangular area in the histogram.
 * 	Ex: [6,2,5,4,1,5,6] => 10 {Last 5+5}.
 */
public class LargestRectangularAreaHistogram {

	public static void main(String[] args) {
		int[] arr = { 6, 2, 5, 4, 1, 5, 6 };
		System.out.println(getMaxAreaEff(arr));
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
	// T(n): O(n) - 3 iterations, S(n): O(n).
	static int getMaxAreaBetter(int[] arr) {
		int n = arr.length, res = 0;
		if (n == 0)
			return 0;
		int[] prevSmallers = StackUtils.getPrevSmallerIndxs(arr);
		int[] nextSmallers = StackUtils.getNextSmallerIndxs(arr);
		for (int i = 0; i < n; i++) {
			int curr = arr[i];
			curr += (i - prevSmallers[i] - 1) * arr[i]; // Area of bars to the left.
			curr += (nextSmallers[i] - i - 1) * arr[i]; // Area of bars to the right.
			res = Math.max(res, curr);
		}
		return res;
	}

	// Calculate the area of an item being smallest when the item is popped out.
	// T(n): O(n) - 3 iterations, S(n): O(n).
	static int getMaxAreaEff(int[] arr) {
		Deque<Integer> stack = new ArrayDeque<>();
		int n = arr.length, res = 0, top, currArea;
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				top = stack.pop(); // Current bar for area calculation.
				// Calculate the area with arr[top] as the smallest (height) bar, where
				// i is the indx of next smaller and stack.peek() is the indx of prev smaller.
				currArea = arr[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
				res = Math.max(res, currArea);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			top = stack.pop();
			currArea = arr[top] * (stack.isEmpty() ? n : (n - stack.peek() - 1));
			res = Math.max(res, currArea);
		}
		return res;
	}

}
