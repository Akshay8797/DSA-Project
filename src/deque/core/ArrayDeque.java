package deque.core;

import utils.MsgUtils;

public class ArrayDeque {

	private static class ArrDeque {
		private int[] deque;
		private int cap, size = 0, front = 0;

		ArrDeque(int n) {
			cap = n;
			deque = new int[cap];
		}

		private int getRearIndx() {
			return (front + size - 1) % cap;
		}

		void insertFront(int x) {
			if (isFull())
				throw new IllegalStateException(MsgUtils.DEQUEUE_FULL);
			front = (front - 1 + cap) % cap;
			deque[front] = x;
			size++;
		}

		void insertRear(int x) {
			if (isFull())
				throw new IllegalStateException(MsgUtils.DEQUEUE_FULL);
			deque[(getRearIndx() + 1) % cap] = x;
			size++;
		}

		boolean isFull() {
			return size == cap;
		}

		void deleteFront() {
			if (isEmpty())
				throw new IllegalStateException(MsgUtils.DEQUEUE_EMPTY);
			front = (front + 1) % cap;
			size--;
		}

		void deleteRear() {
			if (isEmpty())
				throw new IllegalStateException(MsgUtils.DEQUEUE_EMPTY);
			size--;
		}

		boolean isEmpty() {
			return size == 0;
		}

		int getFront() {
			return isEmpty() ? -1 : deque[front];
		}

		int getRear() {
			return isEmpty() ? -1 : deque[getRearIndx()];
		}

		int getSize() {
			return size;
		}

	}

	public static void main(String[] args) {
		ArrDeque deque = new ArrDeque(5);
		deque.insertFront(5);
		printDequeue(deque);
		deque.insertFront(1);
		printDequeue(deque);
		deque.insertRear(3);
		printDequeue(deque);
		deque.deleteFront();
		printDequeue(deque);
		deque.deleteRear();
		printDequeue(deque);
	}

	private static void printDequeue(ArrDeque deque) {
		System.out.println("Front: " + deque.getFront() + ", Rear: " + deque.getRear() + ", Size: " + deque.getSize());
	}

}
