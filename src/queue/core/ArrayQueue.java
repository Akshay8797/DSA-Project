package queue.core;

import utils.MsgUtils;

public class ArrayQueue {

	private static class Queue {
		private int cap, queue[];
		private int front = 0, size = 0;

		Queue(int n) {
			if (n <= 0)
				throw new IllegalArgumentException(MsgUtils.INVALID_CAP);
			this.cap = n;
			queue = new int[n];
		}

		void enque(int x) {
			if (isFull())
				throw new IllegalStateException(MsgUtils.QUEUE_FULL);
			int rear = (gerRearIndx() + 1) % cap;
			queue[rear] = x;
			size++;
		}

		void deque() {
			if (isEmpty())
				throw new IllegalStateException(MsgUtils.QUEUE_EMPTY);
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
			return isEmpty() ? -1 : queue[gerRearIndx()];
		}

		int getSize() {
			return size;
		}

		boolean isFull() {
			return size == cap;
		}

		private int gerRearIndx() {
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
