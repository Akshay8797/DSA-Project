package stack;

import java.util.ArrayDeque;
import java.util.Deque;

// Create a stack that supports getMin() in O(1) Time and space.
public class StackWithGetMinInConstantTS {

	private static class StackWithMin {
		private Deque<Integer> stk;
		private int min;

		StackWithMin() {
			stk = new ArrayDeque<>();
		}

		void push(int x) {
			if (stk.isEmpty()) {
				min = x;
				stk.push(x);
			} else if (x <= min) {
				stk.push(2 * x - min);
				min = x;
			} else
				stk.push(x);
		}

		int pop() {
			int top = stk.pop();
			if (top <= min) {
				int res = min;
				min = 2 * min - top;
				return res;
			} else
				return top;
		}

		int top() {
			int top = stk.peek();
			return top <= min ? min : top;
		}

		int getMin() {
			return min;
		}
	}

	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		stack.push(8);
		stack.push(10);
		stack.push(5);
		System.out.println("Top: " + stack.top());
		stack.pop();
		System.out.println("Min: " + stack.getMin());
	}

}
