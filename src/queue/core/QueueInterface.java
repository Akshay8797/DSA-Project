package queue.core;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueInterface {

	public static void main(String[] args) {
		// Queue<Integer> que = new LinkedList<>();
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(10);
		que.offer(20);
		que.offer(30);
		System.out.println("IsEmpty: " + que.isEmpty() + ", Size: " + que.size());
		System.out.println("Queue: " + que);
		System.out.println("Poll: " + que.poll());
		System.out.println("Peek: " + que.peek());
	}

}
