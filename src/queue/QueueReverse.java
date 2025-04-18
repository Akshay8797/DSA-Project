package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class QueueReverse {

	static void reverse(Queue<Integer> que) {
		Deque<Integer> stack = new ArrayDeque<>();
		while (!que.isEmpty())
			stack.push(que.poll());
		while (!stack.isEmpty())
			que.offer(stack.pop());
	}

	static void recReverse(Queue<Integer> que) {
		if (que.isEmpty())
			return;
		int x = que.poll();
		recReverse(que);
		que.offer(x);
	}

	public static void main(String[] args) {
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(5);
		que.offer(10);
		que.offer(15);
		System.out.println("Original queue: " + que);
		recReverse(que);
		System.out.println("Reversed queue: " + que);
	}

}
