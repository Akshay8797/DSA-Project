package arrays;

import java.util.Arrays;

// Note: Insert and Delete at the end can be done in O(1).
public class ArrayOperations {

	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] = 5;
		arr[1] = 10;
		arr[2] = 20;
		insertElement(arr, 3, 7, 5, 2);
		deleteElement(arr, arr.length, 5);
		Arrays.stream(arr).forEach(System.out::println);
	}

	// n: Size, cap: Capacity, x: Element, pos: Position to insert. Returns size
	// T(n): O(n)
	private static int insertElement(int arr[], int n, int x, int cap, int pos) {
		if (n == cap)
			return n;
		int index = pos - 1;
		for (int i = n - 1; i >= index; i--)
			arr[i + 1] = arr[i];
		arr[index] = x;
		return n + 1;
	}

	// Assuming arr is full, remove x. Returns size
	private static int deleteElement(int[] arr, int n, int x) {
		int i;
		for (i = 0; i < n; i++) {
			if (arr[i] == x)
				break;
		}
		if (i == n)
			return n;
		for (int j = i; j < n - 1; j++)
			arr[j] = arr[j + 1];
		arr[n - 1] = 0; // removing the last element
		return n - 1;
	}

}
