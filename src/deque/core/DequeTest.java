package deque.core;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {

	public static void main(String[] args) {
//		Deque<Integer> deque = new LinkedList<>();
		Deque<Integer> deque = new ArrayDeque<>();
		deque.offerFirst(2);
		deque.offerLast(4); // deque.offer(4);
		deque.offerFirst(6);
		deque.offerLast(8); // deque.offer(8);
		System.out.println("First: " + deque.peekFirst() + ", Last: " + deque.peekLast());
		deque.pollFirst(); // deque.poll();
		deque.pollLast();
		System.out.println("First: " + deque.peekFirst() + ", Last: " + deque.peekLast());
		for (int x : deque) {
			System.out.println(x);
		}
	}

}
