package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*- Given an array of length n and an int k
 * 	Print the elements of the array that occurs more than n/k times.
 */
public class MoreThanAnOccurence {

	public static void main(String[] args) {
		int arr[] = { 30, 10, 20, 20, 10, 20, 30, 30 }, k = 4;
		printMoreThanAnOccr(arr, k);
	}

	// T(n): O(n), S(n): O(n).
	private static void printMoreThanAnOccr(int[] arr, int k) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		int n = arr.length;
		for (int x : arr)
			freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
		for (Entry<Integer, Integer> entry : freqMap.entrySet()) {
			if (entry.getValue() > n / k)
				System.out.print(entry.getKey() + " ");
		}
	}

}
