package queue.core;

public class ArrayQueue {

	private static class Queue {
		private int cap, queue[];
		private int front = 0, size = 0;

		Queue(int cap) {
			this.cap = cap;
			queue = new int[cap];
		}

		void enque(int x) {
			if (isFull()) {
				System.err.println("Enqueue failed: Queue full!");
				return;
			}
			int rear = (getRearIndex() + 1) % cap;
			queue[rear] = x;
			size++;
		}

		void deque() {
			if (isEmpty()) {
				System.err.println("Deque failed: Queue empty!");
				return;
			}
			front = (front + 1) % cap;
			size--;
		}

		boolean isEmpty() {
			return size == 0;
		}

		int getFront() {
			return isEmpty() ? -1 : queue[front];
		}

		int getRear() {
			return isEmpty() ? -1 : queue[getRearIndex()];
		}

		int getSize() {
			return size;
		}

		boolean isFull() {
			return size == cap;
		}

		private int getRearIndex() {
			return (front + size - 1) % cap;
		}
	}

	public static void main(String[] args) {
		Queue que = new Queue(3);
		que.enque(3);
		que.enque(5);
		que.enque(7);
		System.out.println("Front: " + que.getFront() + ", rear: " + que.getRear() + ", size: " + que.getSize());
		que.deque();
		que.deque();
		que.deque();
		System.out.println("Front: " + que.getFront() + ", rear: " + que.getRear() + ", size: " + que.getSize());
	}

}
