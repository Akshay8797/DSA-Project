package searching;

// Given a sorted array, find if there exists a triplet with sum x.
public class TripletInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 8, 9, 20, 40 };
		System.out.println(isTripletExistsWithSumEff(arr, 32));
	}

	// T(n): O(n^3)
	@SuppressWarnings("unused")
	private static boolean isTripletExistsWithSum(int[] arr, int x) {
		int n = arr.length;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					if (arr[i] + arr[j] + arr[k] == x)
						return true;
				}
			}
		}
		return false;
	}

	// T(n): O(n^2)
	private static boolean isTripletExistsWithSumEff(int[] arr, int x) {
		int n = arr.length;
		for (int i = 0; i < n - 2; i++) {
			int low = i + 1, high = n - 1;
			while (low != high) {
				int tripletSum = arr[i] + arr[low] + arr[high];
				if (tripletSum == x)
					return true;
				if (tripletSum > x)
					--high;
				else
					++low;
			}
		}
		return false;
	}

}
