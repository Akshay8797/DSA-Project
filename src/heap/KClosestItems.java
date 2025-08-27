package heap;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

// Given an array and a two nos. x and k. Find k closest elements to x in the array.
public class KClosestItems {

	public static void main(String[] args) {
		int[] arr = { 10, 15, 7, 3, 4 };
		printKClosest(arr, 8, 2);
	}

	record Pair(int diff, int indx) implements Comparable<Pair> {
		@Override
		public int compareTo(Pair otherPair) {
			return Integer.compare(this.diff, otherPair.diff);
		}
	}

	// Eff - T(n): O(k * log k).
	static void printKClosest(int[] arr, int x, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(k, Collections.reverseOrder());
		for (int i = 0; i < k; i++)
			pq.add(new Pair(Math.abs(arr[i] - x), i));
		for (int i = k; i < arr.length; i++) {
			int diff = Math.abs(arr[i] - x);
			if (diff <= pq.peek().diff) {
				pq.poll();
				pq.add(new Pair(diff, i));
			}
		}
		Iterator<Pair> itr = pq.iterator();
		while (itr.hasNext())
			System.out.print(arr[itr.next().indx] + " ");
	}

	// Naive solution - T(n): O(n*k).
	static void printKClosestFromX(int[] arr, int x, int k) {
		int n = arr.length;
		if (k > n)
			return;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < k; i++) {
			int minDiff = Integer.MAX_VALUE, minIndx = -1;
			for (int j = 0; j < n; j++) {
				if (!visited[j] && Math.abs(arr[j] - x) <= minDiff) {
					minDiff = Math.abs(arr[j] - x);
					minIndx = j;
				}
			}
			System.out.print(arr[minIndx] + " ");
			visited[minIndx] = true;
		}
	}

}
