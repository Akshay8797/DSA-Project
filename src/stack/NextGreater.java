package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// Given an int array, print the closest greater on the right of every element.
public class NextGreater {

	public static void main(String[] args) {
		int[] arr = { 5, 15, 10, 8, 6, 12, 9, 18 };
		printClosestRightGreater(arr);
	}

	// T(n): O(n), S(n): O(n) - Stock span variation.
	private static void printClosestRightGreater(int[] arr) {
		int n = arr.length;
		if (n == 0)
			return;
		Deque<Integer> stack = new ArrayDeque<>();
		int[] res = new int[n];
		for (int i = n - 1; i >= 0; i--) { // Iterate backwards.
			while (!stack.isEmpty() && stack.peek() <= arr[i])
				stack.pop();
			int greater = stack.isEmpty() ? -1 : stack.peek();
			res[i] = greater;
			stack.push(arr[i]);
		}
		System.out.println(Arrays.toString(res));
	}

}
