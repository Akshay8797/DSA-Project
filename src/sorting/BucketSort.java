package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import utils.ArrayUtils;

// Used when nos. are uniformly distributed across a range.
public class BucketSort {

	public static void main(String[] args) {
		int[] arr = { 30, 40, 10, 80, 5, 12, 70 };
		bucketSort(arr, 4);
		System.out.println(Arrays.toString(arr));
	}

	// T(n): O(n) - Uniformly distributed data.
	private static void bucketSort(int[] arr, int k) {
		// error case
		if (!ArrayUtils.isArrayValid(arr) || k <= 0) {
			return;
		}
		int max = arr[0], n = arr.length;
		for (int i = 1; i < n; i++) {
			max = Math.max(arr[i], max);
		}
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(k);
		for (int i = 0; i < k; i++) {
			buckets.add(new ArrayList<>());
		}
		// Place array elements into the corresponding buckets
		for (int i = 0; i < n; i++) {
			int bucketIndex = (k * arr[i]) / (max + 1);
			buckets.get(bucketIndex).add(arr[i]);
		}
		// Sort and join the buckets
		int index = 0;
		for (int i = 0; i < k; i++) {
			Collections.sort(buckets.get(i));
			for (int j = 0; j < buckets.get(i).size(); j++) {
				arr[index++] = buckets.get(i).get(j);
			}
		}
	}

}
