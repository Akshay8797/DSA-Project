package sorting;

import java.util.Arrays;

import utils.ArrayUtils;

/*- Based on Selection Sort algorithm, but uses Heap DS.
 * 	T(n): O(n * log n) 
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] arr = { 10, 14, 50, 4, 20 };
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void heapSort(int[] arr) {
		int n = arr.length;
		buildHeap(arr, n);
		for (int i = n - 1; i >= 1; i--) {
			ArrayUtils.swap(arr, 0, i); // since root is max
			maxHeapify(arr, i, 0);
		}
	}

	// T(n): O(n)
	private static void buildHeap(int[] arr, int n) {
		for (int i = (n - 2) / 2; i >= 0; i--) {
			maxHeapify(arr, n, i);
		}
	}

	// T(n): O(log n)
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

}
