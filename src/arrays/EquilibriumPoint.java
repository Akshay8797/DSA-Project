package arrays;

import java.util.Arrays;

/*- Given an array, check if it has an Equilibrium point or not.
 * 	An Equilibrium point is an element where sum of elements before it and after it are same.
 * 	Corner elements can also be considered as Equilibrium point with the corner-most sum as 0.
 * `I/P: [4,2,-2]	=>	O/P: True
 */
public class EquilibriumPoint {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 8, -9, 20, 6 };
		System.out.println(isEquilibriumPointExists(arr));
	}

	private static boolean isEquilibriumPointExists(int[] arr) {
		int n = arr.length, lSum = 0, rSum = Arrays.stream(arr).sum();
		for (int i = 0; i < n; i++) {
			rSum -= arr[i];
			if (lSum == rSum)
				return true;
			lSum += arr[i];
		}
		return false;
	}

}
