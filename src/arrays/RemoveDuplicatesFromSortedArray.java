package arrays;

import java.util.Arrays;

// Given a sorted array remove duplicates from it.
// Keeps the distinct elements in the sorted order and returns the new size.
public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 20, 30, 40, 40 };
		int resIndex = getSizeAfterRemovingDuplicates(arr);
		System.out.println("\nIndex: " + resIndex);
	}

	// Assuming arr has atleast 1 element.
	private static int getSizeAfterRemovingDuplicates(int[] arr) {
		int count = 1;
		// 1st element's entry is always unique.
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[count - 1]) {
				arr[count] = arr[i];
				count++;
			}
		}
		Arrays.fill(arr, count, arr.length, 0);
		Arrays.stream(arr).forEach(System.out::println);
		return count;
	}

}
