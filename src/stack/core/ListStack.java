package stack.core;

import java.util.ArrayList;
import java.util.List;

import utils.MsgUtils;

public class ListStack {

	private static class Stack {
		private List<Integer> list = new ArrayList<>();

		void push(int x) {
			list.add(x);
		}

		int pop() {
			if (list.size() == 0)
				throw new IllegalStateException("Pop " + MsgUtils.STACK_EMPTY);
			int res = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			return res;
		}

		int peek() {
			if (list.size() == 0)
				throw new IllegalStateException("Peek " + MsgUtils.STACK_EMPTY);
			return list.get(list.size() - 1);
		}

		int size() {
			return list.size();
		}

		boolean isEmpty() {
			return list.isEmpty();
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		stack.push(40);
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
	}

}
