package arrays;

import java.util.Arrays;

public class LeftRotateByOne {

	public static void main(String[] args) {
		int[] arr = { 20, 15, 30, 40 };
		Arrays.stream(getLeftRotatedByOne(arr)).forEach(System.out::println);
	}

	private static int[] getLeftRotatedByOne(int[] arr) {
		int first = arr[0], n = arr.length;
		for (int i = 1; i < n; i++) {
			arr[i - 1] = arr[i];
		}
		arr[n - 1] = first;
		return arr;
	}

}
