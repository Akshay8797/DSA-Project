package searching.binarySearch;

import utils.MathUtils;

// Given an infinitely sorted array. Search an element x (closer to the left) if present. 
public class SearchInfiniteSortedArray {

	public static void main(String[] args) {
		int[] arr = new int[1000];
		for (int i = 0; i < 1000; i++)
			arr[i] = i + 10;
		System.out.println(searchInfiniteArrayEff(arr, 100));
	}

	// T(n): O(position)
	@SuppressWarnings("unused")
	private static int searchInfiniteArray(int[] arr, int x) {
		int i = 0;
		while (true) {
			if (arr[i] == x)
				return i;
			if (arr[i] > x)
				return -1;
			i++;
		}
	}

	// T(n): O(log (position)) [Unbounded Binary Search]
	private static int searchInfiniteArrayEff(int[] arr, int x) {
		if (arr[0] == 0)
			return 0;
		int i = 1;
		while (arr[i] < x)
			i *= 2;
		if (arr[i] == x)
			return i;
		return MathUtils.doBinarySearch(arr, x, (i / 2) + 1, i - 1);
	}

}
