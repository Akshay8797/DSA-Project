package stack;

import utils.StackUtils;

// Implement two stacks in an array.
public class TwoStacks {

	private static class Stack {
		private int n, top1, top2;
		private Integer[] arr;

		Stack(int n) {
			this.n = n;
			arr = new Integer[n];
			top1 = -1;
			top2 = n;
		}

		void push1(int x) {
			if (top1 < top2 - 1) {
				top1++;
				arr[top1] = x;
			} else
				StackUtils.stackFullError(x);
		}

		void push2(int x) {
			if (top1 < top2 - 1) {
				top2--;
				arr[top2] = x;
			} else
				StackUtils.stackFullError(x);
		}

		Integer pop1() {
			if (top1 == -1)
				return StackUtils.stackEmptyError("Pop");
			int res = arr[top1];
			top1--;
			return res;
		}

		Integer pop2() {
			if (top2 == n)
				return StackUtils.stackEmptyError("Pop");
			int res = arr[top2];
			top2++;
			return res;
		}

		Integer peek1() {
			if (top1 == -1)
				return StackUtils.stackEmptyError("Peek");
			return arr[top1];
		}

		Integer peek2() {
			if (top2 == n)
				return StackUtils.stackEmptyError("Peek");
			return arr[top2];
		}

		Integer size1() {
			return top1 + 1;
		}

		Integer size2() {
			return n - top2;
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push1(5);
		stack.push1(15);
		stack.push1(25);
		System.out.println("Pop-1: " + stack.pop1());
		System.out.println("Peek-1: " + stack.peek1());
		System.out.println("Size-1: " + stack.size1());
		stack.push2(10);
		stack.push2(20);
		stack.push2(30);
		System.out.println("Pop-2: " + stack.pop2());
		System.out.println("Peek-2: " + stack.peek2());
		System.out.println("Size-2: " + stack.size2());
	}

}
