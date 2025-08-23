package heap;

import java.util.PriorityQueue;

public class PriorityQueueHeap {

	public static void main(String[] args) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap.add(15);
		minHeap.add(10);
		minHeap.add(20);
		System.out.println("Peek: " + minHeap.peek());
		System.out.println("Polled: " + minHeap.poll());
		System.out.println("Peek: " + minHeap.peek());
	}

}
