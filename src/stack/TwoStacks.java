package stack;

import utils.MsgUtils;

// Implement two stacks in an array.
public class TwoStacks {

	private static class Stack {
		private int cap, top1, top2;
		private Integer[] arr;

		Stack(int n) {
			if (n <= 0)
				throw new IllegalArgumentException(MsgUtils.INVALID_CAP);
			this.cap = n;
			arr = new Integer[n];
			top1 = -1;
			top2 = n;
		}

		void push1(int x) {
			if (top1 < top2 - 1) {
				top1++;
				arr[top1] = x;
			} else
				throw new IllegalStateException(MsgUtils.STACK_FULL);
		}

		void push2(int x) {
			if (top1 < top2 - 1) {
				top2--;
				arr[top2] = x;
			} else
				throw new IllegalStateException(MsgUtils.STACK_FULL);
		}

		int pop1() {
			if (top1 == -1)
				throw new IllegalStateException("Pop " + MsgUtils.STACK_EMPTY);
			int res = arr[top1];
			top1--;
			return res;
		}

		int pop2() {
			if (top2 == cap)
				throw new IllegalStateException("Pop " + MsgUtils.STACK_EMPTY);
			int res = arr[top2];
			top2++;
			return res;
		}

		int peek1() {
			if (top1 == -1)
				throw new IllegalStateException("Peek " + MsgUtils.STACK_EMPTY);
			return arr[top1];
		}

		int peek2() {
			if (top2 == cap)
				throw new IllegalStateException("Peek " + MsgUtils.STACK_EMPTY);
			return arr[top2];
		}

		Integer getSize1() {
			return top1 + 1;
		}

		Integer getSize2() {
			return cap - top2;
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push1(5);
		stack.push1(15);
		stack.push1(25);
		System.out.println("Pop-1: " + stack.pop1());
		System.out.println("Peek-1: " + stack.peek1());
		System.out.println("Size-1: " + stack.getSize1());
		stack.push2(10);
		stack.push2(20);
		stack.push2(30);
		System.out.println("Pop-2: " + stack.pop2());
		System.out.println("Peek-2: " + stack.peek2());
		System.out.println("Size-2: " + stack.getSize2());
	}

}
