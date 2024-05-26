package arrays;

import java.util.Arrays;

public class ReverseAnArray {

	public static void main(String[] args) {
		int[] arr = { 10, 5, 7, 30, 12 };
		Arrays.stream(reverse(arr)).forEach(System.out::println);
	}

	// T(n) = O(n)
	private static int[] reverse(int[] arr) {
		int low = 0, high = arr.length - 1;
		while (low < high) {
			ArrayUtils.swap(arr, low, high);
			low++;
			high--;
		}
		return arr;
	}

}
