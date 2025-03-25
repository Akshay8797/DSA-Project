package stack;

import java.util.ArrayDeque;
import java.util.Deque;

// Given an array of distinct int, print the closest greater on the left of every element.
public class PrevGreater {

	public static void main(String[] args) {
		int[] arr = { 15, 10, 18, 12, 4, 6, 2, 8 };
		printClosestLeftGreater(arr);
	}

	// T(n): O(n), S(n): O(n) - Stock span variation.
	private static void printClosestLeftGreater(int[] arr) {
		if (arr.length == 0)
			return;
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && stack.peek() <= arr[i])
				stack.pop();
			int greater = stack.isEmpty() ? -1 : stack.peek();
			System.out.print(greater + " ");
			stack.push(arr[i]);
		}
	}

}
