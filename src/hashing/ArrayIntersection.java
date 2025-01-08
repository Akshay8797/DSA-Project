package hashing;

import java.util.HashSet;

/*- Given two unsorted arrays with distinct elements. Print their intersection.
 * 	Note: Print in the order of the first array.
 * 	a[]: {10, 15, 20, 25, 30, 50}, b[]: {30, 5, 15, 80} => 15 30
 */
public class ArrayIntersection {

	public static void main(String[] args) {
		int[] a = { 10, 15, 20, 25, 30, 50 }, b = { 30, 5, 15, 80 };
		printIntersection(a, b);
	}

	// T(n): O(a+b), S(n): O(b).
	private static void printIntersection(int[] a, int[] b) {
		HashSet<Integer> nums = new HashSet<>(b.length);
		for (int x : b) {
			nums.add(x);
		}
		for (int x : a) {
			if (nums.contains(x))
				System.out.println(x);
		}
	}

}
