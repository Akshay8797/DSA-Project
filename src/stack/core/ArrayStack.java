package stack.core;

import utils.StackUtils;

public class ArrayStack {

	private static class Stack {
		private int cap, top = -1;
		private Integer[] arr;

		Stack(int cap) {
			this.cap = cap;
			arr = new Integer[cap];
		}

		void push(int x) {
			if (top == cap - 1) {
				StackUtils.stackFullError(x);
				return;
			}
			top++;
			arr[top] = x;
		}

		Integer pop() {
			if (top == -1)
				return StackUtils.stackEmptyError("Pop");
			int res = arr[top];
			top--;
			return res;
		}

		Integer peek() {
			if (top == -1)
				return StackUtils.stackEmptyError("Peek");
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
