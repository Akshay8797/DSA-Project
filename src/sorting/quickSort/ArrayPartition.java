package sorting.quickSort;

import java.util.Arrays;

/*-	Given an array arr & an index p. Partition arr around p.
 * 	i.e. Element x <= arr[p] should be to the left and x > arr[p] should be to the right of arr[p].
 * 	Ex: arr = {3, 8, 6, 12, 10, 7}, p = 5  =>  {3, 6, 7, 8, 12, 10}
 * 	Note: Order of elements doesn't matter.
 */
public class ArrayPartition {

	public static void main(String[] args) {
		int[] arr = { 3, 8, 6, 12, 10, 7, 9 };
		partition(arr, 0, 6, 1);
		System.out.println(Arrays.toString(arr));
	}

	// Naive Partition - T(n): O(n), S(n): O(n).
	private static void partition(int arr[], int l, int h, int p) {
		int[] temp = new int[h - l + 1];
		int index = 0;
		for (int i = l; i <= h; i++)
			if (arr[i] <= arr[p] && i != p)
				temp[index++] = arr[i];
		temp[index++] = arr[p];
		for (int i = l; i <= h; i++)
			if (arr[i] > arr[p])
				temp[index++] = arr[i];
		for (int i = l; i <= h; i++)
			arr[i] = temp[i - l];
	}

}
