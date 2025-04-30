package deque;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.MsgUtils;

/*- Design a data structure that supports following in O(1):
 *  Insert min-max (assuming inserted item is smaller or greater than existing items respectively),
 *  Get min-max and Extract min-max.
 */
public class DsWithMinMax {

	private static class MinMaxDeque {
		private Deque<Integer> deque = new ArrayDeque<>();

		void insertMin(int x) {
			deque.offerFirst(x);
		}

		void insertMax(int x) {
			deque.offerLast(x);
		}

		int getMin() {
			if (deque.isEmpty())
				throw new IllegalStateException(MsgUtils.DEQUEUE_EMPTY);
			return deque.peekFirst();
		}

		int getMax() {
			if (deque.isEmpty())
				throw new IllegalStateException(MsgUtils.DEQUEUE_EMPTY);
			return deque.peekLast();
		}

		int extractMin() {
			if (deque.isEmpty())
				throw new IllegalStateException(MsgUtils.DEQUEUE_EMPTY);
			return deque.pollFirst();
		}

		int extractMax() {
			if (deque.isEmpty())
				throw new IllegalStateException(MsgUtils.DEQUEUE_EMPTY);
			return deque.pollLast();
		}
	}

	public static void main(String[] args) {
		MinMaxDeque deque = new MinMaxDeque();
		deque.insertMin(5);
		deque.insertMax(8);
		deque.insertMin(3);
		deque.insertMax(10);
		System.out.println("Min: " + deque.getMin() + ", Max: " + deque.getMax());
		deque.extractMin();
		deque.extractMax();
		System.out.println("Min: " + deque.getMin() + ", Max: " + deque.getMax());
	}

}
