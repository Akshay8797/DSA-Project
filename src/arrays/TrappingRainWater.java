package arrays;

/*- Given an array of non -ve integers representing heights of bars.
 * 	Find the amount of water that can be stored between them.
 * 	I/P: arr[] = {2, 0, 2}; O/P: 2 Units
 * 	Note: When array is sorted asc or dsc, water collected would be 0.
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		int bars[] = { 5, 0, 6, 2, 3 };
		System.out.println(getWaterCapacityEff(bars));
	}

	// T(n): O(n^2)
	@SuppressWarnings("unused")
	private static int getWaterCapacity(int[] bars) {
		int totalCap = 0, n = bars.length;
		for (int i = 1; i < n - 1; i++) {
			int lmax = bars[i], rmax = bars[i];
			for (int j = 0; j < i; j++)
				lmax = Integer.max(lmax, bars[j]);
			for (int j = i + 1; j < n; j++)
				rmax = Integer.max(rmax, bars[j]);
			totalCap += (Integer.min(lmax, rmax) - bars[i]);
		}
		return totalCap;
	}

	// T(n): O(n), S(n): O(n)
	@SuppressWarnings("unused")
	private static int getWaterCapacityUsingPreComputation(int[] bars) {
		int totalCap = 0, n = bars.length, lmax[] = new int[n], rmax[] = new int[n];
		lmax[0] = bars[0];
		for (int i = 1; i < n; i++)
			lmax[i] = Integer.max(lmax[i - 1], bars[i]);
		rmax[n - 1] = bars[n - 1];
		for (int i = n - 2; i >= 0; i--)
			rmax[i] = Integer.max(rmax[i + 1], bars[i]);
		for (int i = 0; i < n; i++)
			totalCap += (Integer.min(lmax[i], rmax[i]) - bars[i]);
		return totalCap;
	}

	// 2 Pointer Approach - T(n): O(n)
	private static int getWaterCapacityEff(int[] bars) {
		int ans = 0, n = bars.length, leftMax = 0, rightMax = 0, l = 0, r = n - 1;
		while (l < r) {
			if (bars[l] > leftMax)
				leftMax = Math.max(leftMax, bars[l]);
			if (bars[r] > rightMax)
				rightMax = Math.max(rightMax, bars[r]);
			if (leftMax < rightMax) {
				ans += (leftMax - bars[l]);
				l++;
			} else {
				ans += (rightMax - bars[r]);
				r--;
			}
		}
		return ans;
	}

}
