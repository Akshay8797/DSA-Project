package queue.core;

import java.util.ArrayDeque;
import java.util.Queue;

// Given Queue library implement a stack.
public class StackUsingQueue {

	private static class Stack {
		private Queue<Integer> que = new ArrayDeque<>();

		void push(int x) {
			int size = que.size();
			que.offer(x);
			// Rotate the queue to move the new element to the front.
			for (int i = 0; i < size; i++)
				que.offer(que.poll());
		}

		Integer pop() {
			return que.poll();
		}

		Integer top() {
			return que.peek();
		}

		Integer size() {
			return que.size();
		}

		boolean isEmpty() {
			return que.isEmpty();
		}

		@Override
		public String toString() {
			return "Stack: " + que;
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		System.out.println("Empty: " + stack.isEmpty());
		stack.push(5);
		stack.push(10);
		stack.push(15);
		System.out.println(stack);
		System.out.println("Top: " + stack.top() + ", Size: " + stack.size());
		stack.pop();
		stack.pop();
		System.out.println(stack);
		System.out.println("Top: " + stack.top() + ", Size: " + stack.size());
	}

}
