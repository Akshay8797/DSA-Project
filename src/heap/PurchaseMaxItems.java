package heap;

import java.util.PriorityQueue;

// Given costs of n items and a sum, find the max items that can be purchased with the given sum.
public class PurchaseMaxItems {

	public static void main(String[] args) {
		int[] arr = { 1, 12, 5, 30, 90 };
		System.out.println(getMaxItems(arr, 10));
	}

	// T(n): O(items * log n).
	private static int getMaxItems(int[] arr, int sum) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int x : arr)
			pq.add(x);
		int items = 0;
		while (sum - pq.peek() >= 0) {
			items++;
			sum -= pq.poll();
		}
		return items;
	}

}
