package sorting.quickSort;

import java.util.Arrays;
import java.util.Random;

import utils.ArrayUtils;

/*- T(n) in worst case is O(n ^ 2), average is O(n * log n).
 * 	It is in-place (apart from the recursion call stack) and tail recursive.
 * 	QS is unstable (mostly uses Hoare's partition) as opposed to merge sort which is stable.
 */
public class QuickSort {

	private static final Random random = new Random();

	public static void main(String[] args) {
		int[] arr = { 8, 4, 7, 9, 3, 10, 5 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	// Using Lomuto Partition
	static void quickSort(int[] arr, int l, int h) {
		if (l < h) {
			int p = ArrayLomutoPartition.lPartition(arr, l, h);
			quickSort(arr, l, p - 1);
			quickSort(arr, p + 1, h);
		}
	}

	// Using Hoare's Partition
	static void qSort(int[] arr, int l, int h) {
		if (l < h) {
			int p = ArrayHoarePartition.hPartition(arr, l, h);
			qSort(arr, l, p);
			qSort(arr, p + 1, h);
		}
	}

	public static void randomizePivot(int[] arr, int low, int high, char partitionType) {
		int randomPivotIndex = random.nextInt(low, high + 1); // To avoid worst-case
		if (partitionType == 'l') // Lomuto partition
			ArrayUtils.swap(arr, high, randomPivotIndex);
		else if (partitionType == 'h') // Hoare's partition
			ArrayUtils.swap(arr, low, randomPivotIndex);
	}

}
