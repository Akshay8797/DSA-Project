package utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackUtils {

	public static void stackFullError(int x) {
		System.err.println("Push " + x + " failed - Stack is full!");
	}

	public static void stackFullError(int x, int stackNum) {
		System.err.println("Push " + x + " failed - Stack " + stackNum + " is full!");
	}

	public static Integer stackEmptyError(String action) {
		if (action.equalsIgnoreCase("Pop"))
			System.err.println("Pop failed - Stack is empty!");
		else if (action.equalsIgnoreCase("Peek"))
			System.err.println("Peek failed - Stack is empty!");
		else
			System.err.println("Stack is empty!");
		return null;
	}

	public static Integer stackEmptyError(String action, int stackNum) {
		if (action.equalsIgnoreCase("Pop"))
			System.err.println("Pop failed - Stack " + stackNum + " is empty!");
		else if (action.equalsIgnoreCase("Peek"))
			System.err.println("Peek failed - Stack " + stackNum + " is empty!");
		else
			System.err.println("Stack " + stackNum + " is empty!");
		return null;
	}

	// Gets the previous smaller indexes array.
	public static int[] getPrevSmallerIndxs(int[] arr) {
		Deque<Integer> stack = new ArrayDeque<>();
		int n = arr.length, prevSmallers[] = new int[n];
		for (int i = 0; i < n; i++) {
			// While greater elements present pop out.
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
				stack.pop();
			// Previous smaller if not present put index as -1.
			int prevSmaller = stack.isEmpty() ? -1 : stack.peek();
			prevSmallers[i] = prevSmaller;
			stack.push(i);
		}
		return prevSmallers;
	}

	// Gets the next smaller indexes array
	public static int[] getNextSmallerIndxs(int[] arr) {
		Deque<Integer> stack = new ArrayDeque<>();
		int n = arr.length, nextSmallers[] = new int[n];
		for (int i = n - 1; i >= 0; i--) { // Reverse iterate.
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
				stack.pop();
			// Next smaller if not present put index as n.
			int nextSmaller = stack.isEmpty() ? n : stack.peek();
			nextSmallers[i] = nextSmaller;
			stack.push(i);
		}
		return nextSmallers;
	}

}
