package arrays;

// A majority element is an element that appears more than n/2 times.
public class MajorityElement {

	public static void main(String[] args) {
		int[] arr = { 8, 8, 6, 6, 6, 4, 6 };
		System.out.println(getMajorityIndexEff(arr));
	}

	@SuppressWarnings("unused")
	private static int getMajorityIndex(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int count = 1;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] == arr[i])
					count++;
			}
			if (count > n / 2)
				return i;
		}
		return -1;
	}

	// Moore's voting algorithm (Might not return the first index of the Majority)
	// T(n): O(n)
	private static int getMajorityIndexEff(int[] arr) {
		// Find a majority candidate
		int res = 0, count = 1, n = arr.length;
		for (int i = 1; i < n; i++) {
			if (arr[res] == arr[i])
				count++;
			else
				count--;
			if (count == 0) {
				res = i;
				count = 1;
			}
		}

		// Check if the candidate is actually a majority
		count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[res] == arr[i])
				count++;
		}
		if (count <= n / 2)
			res = -1;
		return res;
	}
}
