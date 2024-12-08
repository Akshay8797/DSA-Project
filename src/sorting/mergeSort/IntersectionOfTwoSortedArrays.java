package sorting.mergeSort;

/*- Given two sorted arrays. Print the intersection or common elements of the array.
 * 	Note: Duplicates should only be printed once.
 */
public class IntersectionOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] a = { 3, 5, 10, 10, 10, 15, 15, 20 };
		int[] b = { 5, 10, 10, 15, 30 };
		// OP: 5 10 15
		printIntersection(a, b);
	}

	// T(n): O(n1 + n2)
	private static void printIntersection(int[] a, int[] b) {
		int i = 0, j = 0, n1 = a.length, n2 = b.length;
		while (i < n1 && j < n2) {
			if (a[i] > b[j])
				j++;
			else if (a[i] < b[j])
				i++;
			else {
				if (i == 0 || (a[i] != a[i - 1]))
					System.out.println(a[i]);
				i++;
				j++;
			}
		}
	}

}
