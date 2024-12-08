package sorting.mergeSort;

import utils.ArrayUtils;

/*- Given two sorted arrays. Print the union or all elements in both arrays.
 * 	Note: Each element should be printed once.
 */
public class UnionOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] a = { 3, 5, 8 };
		int[] b = { 2, 8, 9, 10, 15 };
		// OP: 2 3 5 8 9 10 15
		printUnion(a, b);
	}

	// T(n): O(n1 + n2)
	private static void printUnion(int[] a, int[] b) {
		int i = 0, j = 0, n1 = a.length, n2 = b.length;
		while (i < n1 && j < n2) {
			if (i > 0 && a[i] == a[i - 1]) {
				i++;
				continue;
			}
			if (j > 0 && b[j] == b[j - 1]) {
				j++;
				continue;
			}
			if (a[i] > b[j]) {
				System.out.println(b[j]);
				j++;
			} else if (a[i] < b[j]) {
				System.out.println(a[i]);
				i++;
			} else {
				System.out.println(a[i]);
				i++;
				j++;
			}
		}
		// Only executes when n1 and n2 are different
		ArrayUtils.printFromIndexWithoutDup(a, i, n1);
		ArrayUtils.printFromIndexWithoutDup(b, j, n2);
	}

}
