package queue.core;

import linkedList.core.Node;
import utils.MsgUtils;

public class LinkedListQueue {

	private static class Queue {
		private int size = 0;
		private Node front = null, rear = null;

		void enque(int x) {
			Node node = new Node(x);
			size++;
			if (front == null) {
				front = node;
				rear = node;
				return;
			}
			rear.next = node;
			rear = node;
		}

		void deque() {
			if (front == null)
				throw new IllegalStateException(MsgUtils.QUEUE_EMPTY);
			front = front.next;
			size--;
			if (front == null)
				rear = null;
		}

		boolean isEmpty() {
			return size == 0;
		}

		int getFrontElement() {
			return isEmpty() ? -1 : front.data;
		}

		int getRearElement() {
			return isEmpty() ? -1 : rear.data;
		}

		int getSize() {
			return size;
		}
	}

	public static void main(String[] args) {
		Queue que = new Queue();
		System.out.println("Size: " + que.getSize());
		que.enque(5);
		que.enque(10);
		System.out.print("Size: " + que.getSize() + " ");
		System.out.println("Front: " + que.getFrontElement() + ", Rear: " + que.getRearElement());
		que.deque();
		que.deque();
		System.out.print("Size: " + que.getSize() + " ");
		System.out.println("Front: " + que.getFrontElement() + ", Rear: " + que.getRearElement());
		que.deque();
	}

}
