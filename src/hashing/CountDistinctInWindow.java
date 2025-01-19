package hashing;

import java.util.HashMap;
import java.util.Map;

/*- Given an array arr[n] and a no. k <= n.
 * 	Find the distinct elements count in every window of size k in arr.
 * 	No. of windows = n-k+1
 * 	I/p: [10, 20, 20, 10, 30, 40, 10], k: 4  =>  O/p: 2, 3, 4, 3
 */
public class CountDistinctInWindow {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 20, 10, 30, 40, 10 };
		distinctElementsCountInWindow(arr, 4);
	}

	// T(n): O(n).
	private static void distinctElementsCountInWindow(int[] arr, int k) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int i = 0; i < k; i++) {
			freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
		}
		System.out.print(freqMap.size() + " ");

		for (int i = k; i < arr.length; i++) {
			int x = arr[i - k];
			freqMap.put(x, freqMap.get(x) - 1);
			if (freqMap.get(x) == 0)
				freqMap.remove(x);
			freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
			System.out.print(freqMap.size() + " ");
		}
	}

}
