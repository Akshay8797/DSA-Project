package heap.core;

import java.util.Arrays;

import utils.ArrayUtils;

/*- Heap Sort is based on Selection Sort - Find the max element and swap it with the last.
 * 	Instead of linearly searching for max element Heap Sort uses Max Heap.
 * 	Build MaxHeap -> Swap the root with the last element -> heapSize - 1 and call heapify on the root.
 */
public class HeapSort {

	static void buildMaxHeap(int[] arr) {
		int n = arr.length;
		for (int i = (n - 2) / 2; i >= 0; i--)
			maxHeapify(arr, n, i);
	}

	private static void maxHeapify(int[] arr, int n, int i) {
		int largest = i, left = 2 * i + 1, right = 2 * i + 2;
		if (left < n && arr[left] > arr[largest])
			largest = left;
		if (right < n && arr[right] > arr[largest])
			largest = right;
		if (largest != i) {
			ArrayUtils.swap(arr, largest, i);
			maxHeapify(arr, n, largest);
		}
	}

	// T(n): O(n * log n).
	public static void main(String[] args) {
		int[] hp = { 10, 15, 50, 4, 20 };
		buildMaxHeap(hp);
		System.out.println("MaxHeap: " + Arrays.toString(hp));
		for (int i = hp.length - 1; i >= 1; i--) {
			ArrayUtils.swap(hp, 0, i);
			maxHeapify(hp, i, 0);
		}
		System.out.println("Sorted: " + Arrays.toString(hp));
	}

}
