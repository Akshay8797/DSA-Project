package stack;

import java.util.ArrayDeque;
import java.util.Deque;

// Create a stack that supports getMin() in O(1) Time.
public class StackWithGetMin {

	private static class StackWithMin {
		private Deque<Integer> stk, auxStk;

		StackWithMin() {
			stk = new ArrayDeque<>();
			auxStk = new ArrayDeque<>();
		}

		void push(int x) {
			if (auxStk.isEmpty() || auxStk.peek() >= x)
				auxStk.push(x);
			stk.push(x);
		}

		Integer pop() {
			if (auxStk.peek() == stk.peek())
				auxStk.pop();
			return stk.pop();
		}

		Integer top() {
			return stk.peek();
		}

		Integer getMin() {
			return auxStk.peek();
		}
	}

	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		stack.push(5);
		stack.push(10);
		stack.push(2);
		System.out.println("Top: " + stack.top());
		System.out.println("Min: " + stack.getMin());
		stack.pop();
		System.out.println("Min: " + stack.getMin());
	}

}
