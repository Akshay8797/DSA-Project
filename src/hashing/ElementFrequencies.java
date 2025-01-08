package hashing;

import java.util.HashMap;

public class ElementFrequencies {

	// T(n): O(n), S(n): O(n)
	public static void main(String[] args) {
		int[] arr = { 10, 12, 10, 15, 10, 20, 12, 12 };
		HashMap<Integer, Integer> freq = new HashMap<>();
		for (int num : arr) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}
		freq.forEach((k, v) -> System.out.println(k + " : " + v));
	}

}
