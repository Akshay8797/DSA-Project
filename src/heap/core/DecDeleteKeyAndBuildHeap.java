package heap.core;

import utils.ArrayUtils;

public class DecDeleteKeyAndBuildHeap extends HeapifyAndExtractMin {

	public DecDeleteKeyAndBuildHeap(int[] hp, int cap) {
		super(hp, cap);
	}

	// Decrease a key at index i to x - T(n): O(log n).
	void decreaseKey(int i, int x) {
		if (i < 0 || i >= size)
			throw new IllegalArgumentException("Index out of bound!");
		if (x > heap[i])
			throw new IllegalArgumentException("New key is greater than existing!");
		heap[i] = x;
		int parent = parentIndx(i);
		// Similar to minHeapify but upwards.
		while (i > 0 && heap[parent] > heap[i]) {
			ArrayUtils.swap(heap, i, parent);
			i = parent;
			parent = parentIndx(i);
		}
	}

	// Delete key at index i - T(n): O(log n).
	void deleteKey(int i) {
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}

	// Given a random array change it to minHeap - T(n): O(n).
	void buildMinHeap() {
		// (size-2)/2 represents the bottom-right most internal node - last non-leaf node.
		for (int i = (size - 2) / 2; i >= 0; i--) {
			minHeapify(i);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 40, 80, 100, 70 };
		DecDeleteKeyAndBuildHeap hp = new DecDeleteKeyAndBuildHeap(arr, arr.length);
		hp.printHeap("Initial Heap");
		hp.decreaseKey(3, 5);
		hp.printHeap("Post decKey(3,5)");
		hp.deleteKey(4);
		hp.printHeap("Post delete(4)");

		System.out.println();
		int[] arr2 = { 10, 5, 20, 2, 4, 8 };
		DecDeleteKeyAndBuildHeap hp2 = new DecDeleteKeyAndBuildHeap(arr2, arr2.length);
		hp2.printHeap("Initial array");
		hp2.buildMinHeap(); // minHeap: {2, 4, 8, 5, 10, 20}
		hp2.printHeap("Post buildMinHeap");
	}

}
