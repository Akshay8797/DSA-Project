package stack.core;

import linkedList.core.Node;
import utils.StackUtils;

public class LinkedListStack {

	// Eff: Push and pop at the head instead of tail.
	private static class Stack {
		private Node head = null;
		private int size = 0;

		void push(int x) {
			Node node = new Node(x);
			node.next = head;
			head = node;
			size++;
		}

		Integer pop() {
			if (head == null)
				return StackUtils.stackEmptyError("Pop");
			int res = head.data;
			head = head.next;
			size--;
			return res;
		}

		Integer peek() {
			if (head == null)
				return StackUtils.stackEmptyError("Peek");
			return head.data;
		}

		Integer size() {
			return size;
		}

		boolean isEmpty() {
			return head == null;
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
		stack.push(30);
		System.out.println(stack.size());
	}

}
