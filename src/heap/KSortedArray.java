package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/*- Given a k-Sorted array, sort the array.
 * 	k-Sorted array: Element at indx i will be in the range i-k to i+k in the sorted array.
 * 	arr: [9,8,7,18,19,17], k: 2 => [7,8,9,17,18,19].
 */
public class KSortedArray {

	public static void main(String[] args) {
		int[] arr = { 9, 8, 7, 18, 19, 17 };
		sortKSorted(arr, 2);
		System.out.println(Arrays.toString(arr));
	}

	// T(n): O(n * log k)
	private static void sortKSorted(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i <= k; i++)
			pq.add(arr[i]);
		int indx = 0; // Indx is the position to insert next in the sorted array.
		for (int i = k + 1; i < arr.length; i++) {
			arr[indx++] = pq.poll();
			pq.add(arr[i]);
		}
		while (!pq.isEmpty())
			arr[indx++] = pq.poll();
	}

}
