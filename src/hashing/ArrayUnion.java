package hashing;

import java.util.HashSet;

/*- Given two unsorted arrays. Print count of distinct elements in their union.
 * 	Note: Print in the order of the first array.
 * 	a[]: {15, 20, 5, 15}, b[]: {15, 5, 10} => 4
 */
public class ArrayUnion {

	public static void main(String[] args) {
		int[] a = { 15, 20, 5, 15 }, b = { 15, 5, 10 };
		printDistinctCount(a, b);
	}

	// T(n): O(a+b), S(n): O(a+b).
	private static void printDistinctCount(int[] a, int[] b) {
		HashSet<Integer> dis = new HashSet<Integer>();
		for (int x : a) {
			dis.add(x);
		}
		for (int x : b) {
			dis.add(x);
		}
		System.out.println(dis.size());
	}

}
