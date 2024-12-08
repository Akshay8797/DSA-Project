package sorting.mergeSort;

// Given two sorted arrays, print the merged array
public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int[] a = { 10, 15, 20 };
		int[] b = { 5, 6, 8, 15 };
		printMerged(a, b);
	}

	// T(n): O(iLen + jLen)
	private static void printMerged(int[] a, int[] b) {
		int i = 0, j = 0, iLen = a.length, jLen = b.length;
		while (i < iLen && j < jLen) {
			if (a[i] <= b[j]) {
				System.out.print(a[i] + " ");
				i++;
			} else {
				System.out.print(b[j] + " ");
				j++;
			}
		}
		while (i < iLen) {
			System.out.print(a[i] + " ");
			i++;
		}
		while (j < jLen) {
			System.out.print(b[j] + " ");
			j++;
		}
	}

}
