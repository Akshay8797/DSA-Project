package heap.core;

import java.util.Arrays;

import utils.ArrayUtils;

public class MinHeapInsert extends MinHeap {

	public MinHeapInsert(int cap) {
		super(cap);
	}

	public MinHeapInsert(int[] heap, int cap) {
		super(heap, cap);
	}

	public void insert(int x) {
		if (size == cap)
			throw new IllegalStateException("Heap is full!");
		size++;
		heap[size - 1] = x;
		for (int i = size - 1; i != 0 && (heap[parentIndx(i)] > heap[i]); i = parentIndx(i))
			ArrayUtils.swap(heap, i, parentIndx(i));
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 15, 40, 50, 100, 25, 45 };
		MinHeapInsert hp = new MinHeapInsert(arr, 9);
		hp.insert(12);
		System.out.println(Arrays.toString(hp.heap));
	}

}
