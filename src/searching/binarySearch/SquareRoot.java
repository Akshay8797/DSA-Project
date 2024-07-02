package searching.binarySearch;

import utils.MathUtils;

// Given an int x, calculate the floor of square root of x.
public class SquareRoot {

	public static void main(String[] args) {
		System.out.println(getSqrootEff(20));
	}

	@SuppressWarnings("unused")
	// T(n): O(x ^ (1/2))
	private static int getSqroot(int x) {
		int i = 1;
		while (i * i <= x)
			i++;
		return (i - 1);
	}

	// T(n): O(log x)
	private static int getSqrootEff(int x) {
		if (x == 0 || x == 1)
			return x;

		int start = 1, end = x / 2, res = -1; // Optimized end for x >= 4
		while (start <= end) {
			int mid = MathUtils.getMidpoint(start, end);
			int midSq = mid * mid;
			if (midSq == x)
				return mid;
			else if (midSq > x)
				end = mid - 1;
			else {
				res = mid;
				start = mid + 1;
			}
		}
		return res;
	}

}
