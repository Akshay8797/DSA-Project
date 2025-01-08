package hashing;

import java.util.HashSet;

public class CountDistinctElements {

	// T(n): O(n), S(n): O(n)
	public static void main(String[] args) {
		int[] arr = { 15, 12, 13, 12, 13, 13, 18 };
		HashSet<Integer> nums = new HashSet<>();
		for (int num : arr) {
			nums.add(num);
		}
		System.out.println(nums.size());
	}

}
