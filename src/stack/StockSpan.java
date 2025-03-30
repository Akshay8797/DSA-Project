package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*- Given an array representing prices of stock on n consecutive days.
 * 	Find the span of the stock on each day. 
 * 	Span: The max no. of consecutive days before and including the curr day, 
 * 		for which the price of the stock on the curr day is less than or equal to its curr price.
 * 	Ex: arr = [13, 15, 12, 14, 16, 8, 6, 4, 10, 30]
 * 		spans = 1, 2, 1, 2, 5, 1, 1, 1, 4, 10	
 */
public class StockSpan {

	public static void main(String[] args) {
		int[] arr = { 18, 12, 13, 14, 11, 16 };
		printSpans(arr);
	}

	/*- Span = Current index - Index of closest greater element on the left.
	 *		If no greater element: Span = curr index + 1.
	 * 	T(n): O(n) {Each item is pushed into the stack once and popped at-most once} , S(n): O(n).
	 */
	private static void printSpans(int[] arr) {
		if (arr.length == 0)
			return;
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) // Trying to get closest greater.
				stack.pop();
			int span = stack.isEmpty() ? i + 1 : i - stack.peek();
			System.out.print(span + " ");
			stack.push(i);
		}
	}

	// T(n): O(n^2).
	static void printSpansNaive(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int span = 1;
			for (int j = i - 1; j >= 0 && arr[j] <= arr[i]; j--)
				span++;
			System.out.print(span + " ");
		}
	}

}
