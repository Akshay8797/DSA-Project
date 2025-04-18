package stack.core;

import utils.MsgUtils;

public class ArrayStack {

	private static class Stack {
		private int cap, top = -1;
		private Integer[] arr;

		Stack(int n) {
			if (n <= 0)
				throw new IllegalArgumentException(MsgUtils.INVALID_CAP);
			cap = n;
			arr = new Integer[n];
		}

		void push(int x) {
			if (top == cap - 1)
				throw new IllegalStateException(MsgUtils.STACK_FULL);
			top++;
			arr[top] = x;
		}

		int pop() {
			if (top == -1)
				throw new IllegalStateException("Pop " + MsgUtils.STACK_EMPTY);
			int res = arr[top];
			top--;
			return res;
		}

		int peek() {
			if (top == -1)
				throw new IllegalStateException("Peek " + MsgUtils.STACK_EMPTY);
			return arr[top];
		}

		Integer size() {
			return top + 1;
		}

		boolean isEmpty() {
			return top == -1;
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack(3);
		stack.push(5);
		stack.push(15);
		stack.push(25);
		stack.push(35);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		stack.push(35);
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
	}

}
