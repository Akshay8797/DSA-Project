package searching.binarySearch;

import utils.MathUtils;

// I/P: arr[] = [10, 20, 30, 40, 50, 8, 9] and x=30  =>  O/P: 2.
public class SearchSortedRotatedArray {

	public static void main(String[] args) {
		int[] arr = { 100, 200, 300, 400, 50, 70 };
		System.out.println(serchSortedAndRotatedArr(arr, 400));
	}

	// T(n): O(log n)
	private static int serchSortedAndRotatedArr(int[] arr, int x) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = MathUtils.getMidpoint(low, high);
			if (arr[mid] == x)
				return mid;
			if (arr[low] <= arr[mid]) {
				// left half sorted
				if (x >= arr[low] && x < arr[mid])
					high = mid - 1;
				else
					low = mid + 1;
			} else {
				// right half sorted
				if (x > arr[mid] && x <= arr[high])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}
		return -1;
	}

}
