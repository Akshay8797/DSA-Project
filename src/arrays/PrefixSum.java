package arrays;

// Given a fixed array and a multiple ranges sum query. Find the sum and the weighted sum efficiently. 
public class PrefixSum {

	public static void main(String[] args) {
		int[] arr = { 2, 8, 3, 9, 6, 5, 4 };
		int[] prefixSumArr = initializePrefixSumArray(arr);
		System.out.println(getSum(0, 2, prefixSumArr));
		System.out.println(getSum(2, 6, prefixSumArr));

		int[] prefixWtSumArr = initializePrefixWtSumArray(arr);
		System.out.println(getWtSum(0, 2, prefixWtSumArr, prefixSumArr));
		System.out.println(getWtSum(2, 5, prefixWtSumArr, prefixSumArr));
	}

	private static int[] initializePrefixSumArray(int[] arr) {
		int n = arr.length;
		int[] prefixSumArr = new int[n];
		prefixSumArr[0] = arr[0];
		for (int i = 1; i < n; i++)
			prefixSumArr[i] = prefixSumArr[i - 1] + arr[i];
		return prefixSumArr;
	}

	private static int getSum(int l, int r, int[] prefixSumArr) {
		if (l == 0)
			return prefixSumArr[r];
		return prefixSumArr[r] - prefixSumArr[l - 1];
	}

	private static int[] initializePrefixWtSumArray(int[] arr) {
		int n = arr.length;
		int[] prefixWtSumArr = new int[n];
		prefixWtSumArr[0] = 0; // 0 * arr[0]
		for (int i = 1; i < n; i++)
			prefixWtSumArr[i] = prefixWtSumArr[i - 1] + (i * arr[i]);
		return prefixWtSumArr;
	}

	// Weighted sum requires 2 prefix arrays
	private static int getWtSum(int l, int r, int[] prefixWtSumArr, int[] prefixSumArr) {
		if (l == 0)
			return prefixWtSumArr[r] - ((l - 1) * getSum(l, r, prefixSumArr));
		return (prefixWtSumArr[r] - prefixWtSumArr[l - 1]) - ((l - 1) * getSum(l, r, prefixSumArr));
	}

}
