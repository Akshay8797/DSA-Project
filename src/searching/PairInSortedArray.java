package searching;

// Given a sorted array, find if there exists a pair with sum x.
public class PairInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 8, 12, 30 };
		System.out.println(isPairExistsWithSum(arr, 17));
	}

	// T(n): O(n) [Two pointer approach]
	// For unsorted array use Hashing.
	private static boolean isPairExistsWithSum(int[] arr, int x) {
		int low = 0, high = arr.length - 1;
		while (low != high) {
			int sum = arr[low] + arr[high];
			if (sum == x)
				return true;
			if (sum > x)
				--high;
			else
				++low;
		}
		return false;
	}

}
