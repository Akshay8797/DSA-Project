package utils;

public class MathUtils {

	public static int getMidpoint(int low, int high) {
		// To avoid overflow with (low + high) / 2
		return low + (high - low) / 2;
	}

	public static int doBinarySearch(int[] arr, int element, int low, int high) {
		while (low <= high) {
			int mid = getMidpoint(low, high);
			if (arr[mid] == element)
				return mid;
			if (arr[mid] > element)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

}
