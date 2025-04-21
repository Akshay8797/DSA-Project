package queue.core;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingStack {

	private static class Queue {
		private Deque<Integer> stk1 = new ArrayDeque<>();
		private Deque<Integer> stk2 = new ArrayDeque<>();

		/*- Transfer all the elements of stk1 to stk2, push the new element to stk1.
		 * 	Then transfer stk2 elements back to stk1. Can also be done using recursion.
		 */
		void enque(int x) {
			while (!stk1.isEmpty())
				stk2.push(stk1.pop());
			stk1.push(x);
			while (!stk2.isEmpty())
				stk1.push(stk2.pop());
		}

		Integer dequeue() {
			return isEmpty() ? null : stk1.pop();
		}

		Integer getFront() {
			return isEmpty() ? null : stk1.peek();
		}

		boolean isEmpty() {
			return stk1.isEmpty();
		}

		Integer size() {
			return stk1.size();
		}

		@Override
		public String toString() {
			return "Queue: " + stk1;
		}
	}

	public static void main(String[] args) {
		Queue que = new Queue();
		que.enque(5);
		que.enque(10);
		que.enque(15);
		System.out.println(que);
		que.dequeue();
		System.out.println("Front: " + que.getFront() + ", Size: " + que.size());
	}

}
