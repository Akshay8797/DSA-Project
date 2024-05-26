package arrays;

import java.util.Arrays;

// Move all the zeroes in the array to the end maintaining the order.
public class MoveAllZeroesToEnd {

	public static void main(String[] args) {
		int[] arr = { 8, 5, 0, 10, 0, 20 };
		Arrays.stream(moveZeroesToEndEff(arr)).forEach(System.out::println);
	}

	// T(n): O(n^2)
	@SuppressWarnings("unused")
	private static int[] moveZeroesToEnd(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				for (int j = i + 1; j < n; j++) {
					if (arr[j] != 0) {
						ArrayUtils.swap(arr, i, j);
						break;
					}
				}
			}
		}
		return arr;
	}

	// T(n): O(n)
	private static int[] moveZeroesToEndEff(int[] arr) {
		int n = arr.length;
		int i = 0, index = 0;
		while (i < n) {
			if (arr[i] != 0) {
				ArrayUtils.swap(arr, i, index);
				index++;
			}
			i++;
		}
		return arr;
	}

}
