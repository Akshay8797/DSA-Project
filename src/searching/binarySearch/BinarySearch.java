package searching.binarySearch;

import utils.MathUtils;

// Given a sorted array, find the index of the element to be searched
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		System.out.println(binarySearchIndex(arr, 20));
		System.out.println(binarySearchRec(0, arr.length - 1, arr, 40));
	}

	// T(n): O(log n)
	private static int binarySearchIndex(int[] arr, int elem) {
		int n = arr.length, low = 0, high = n - 1;
		while (low <= high) {
			int mid = MathUtils.getMidpoint(low, high);
			if (arr[mid] == elem)
				return mid;
			if (arr[mid] > elem)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	// T(n): O(log n), S(n): O(log n)
	private static int binarySearchRec(int low, int high, int[] arr, int elem) {
		if (low > high)
			return -1;
		int mid = MathUtils.getMidpoint(low, high);
		if (arr[mid] == elem)
			return mid;
		else if (arr[mid] > elem)
			return binarySearchRec(low, mid - 1, arr, elem);
		else
			return binarySearchRec(mid + 1, high, arr, elem);
	}

}
