package deque;

import java.util.ArrayDeque;
import java.util.Deque;

/*- Given an array, print the maximums in all contiguous sub-arrays of size k.
 * 	[10, 8, 5, 12, 15, 7, 6] and k = 3 => 10 12 15 15 15
 */
public class MaxInAllSubarraysOfSizeK {

	/*- T(n): O(n).
	 * 	Deque has elements (indexes) stored in decreasing order.
	 */
	private static void generateAllMaxInSubarrays(int[] arr, int k) {
		int n = arr.length;
		Deque<Integer> deque = new ArrayDeque<>(n);
		for (int i = 0; i < k; i++) {
			removeSmallerElementsAndAddCurrent(arr, deque, i);
		}
		for (int i = k; i < n; i++) {
			System.out.print(arr[deque.peekFirst()] + " ");
			// Remove indexes which are not part of the next window.
			while (!deque.isEmpty() && deque.peekFirst() <= i - k)
				deque.pollFirst();
			removeSmallerElementsAndAddCurrent(arr, deque, i);
		}
		// Print the last window's maximum.
		System.out.println(arr[deque.peekFirst()]);
	}

	private static void removeSmallerElementsAndAddCurrent(int[] arr, Deque<Integer> deque, int i) {
		while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
			deque.pollLast();
		deque.offerLast(i);
	}

	public static void main(String[] args) {
		int[] arr = { 10, 8, 5, 12, 15, 7, 6 };
		generateAllMaxInSubarrays(arr, 3);
	}

}
