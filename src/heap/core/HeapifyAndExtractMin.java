package heap.core;

import utils.ArrayUtils;

/*- Min Heapify: Given a min heap with one possible node that is violating min heap property.
 * 	Used as a subroutine in extract min and build heap. Fixes violations from node i downwards.
 */
public class HeapifyAndExtractMin extends Heap {

	public HeapifyAndExtractMin(int[] heap, int cap) {
		super(heap, cap);
	}

	// T(n): O(log n).
	void minHeapify(int i) {
		int lt = leftIndx(i), rt = rightIndx(i);
		int smallest = i;
		if (lt < size && heap[lt] < heap[i])
			smallest = lt;
		if (rt < size && heap[rt] < heap[smallest])
			smallest = rt;
		if (smallest != i) {
			ArrayUtils.swap(heap, i, smallest);
			minHeapify(smallest);
		}
	}

	// T(n): O(log n).
	Integer extractMin() {
		if (size == 0)
			return null;
		int min = heap[0];
		heap[0] = heap[size - 1];
		size--;
		if (size == 1)
			return min;
		minHeapify(0);
		return min;
	}

	public static void main(String[] args) {
		int[] arr = { 40, 20, 30, 35, 25, 80, 32, 100, 70, 60 };
		HeapifyAndExtractMin hp = new HeapifyAndExtractMin(arr, 10);
		hp.printHeap("Initial Heap");
		hp.minHeapify(0);
		hp.printHeap("Post minHeapify(0)");
		System.out.println("Min: " + hp.extractMin());
		hp.printHeap("Post extractMin");
	}

}
