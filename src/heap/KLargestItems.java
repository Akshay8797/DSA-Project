package heap;

import java.util.PriorityQueue;

/*- Given n items and a no. k, print k largest items (increasing order) from the array.
 *  One solution can be to build a max heap and extract k items.
 *  	Stack can be used for order => T(n) becomes O(n + (k * log n)).
 */
public class KLargestItems {

	public static void main(String[] args) {
		int[] arr = { 8, 6, 10, 4, 9, 15, 12 };
		printKLargest(arr, 3);
	}

	// Uses minHeap of size k. T(n): O(k + (n-k) * log k).
	private static void printKLargest(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(k);
		int i = 0, n = arr.length;
		for (i = 0; i < k; i++)
			pq.add(arr[i]);
		for (i = k; i < n; i++) {
			if (arr[i] > pq.peek()) {
				pq.poll();
				pq.add(arr[i]);
			}
		}
		while (!pq.isEmpty())
			System.out.print(pq.poll() + " ");
	}

}
