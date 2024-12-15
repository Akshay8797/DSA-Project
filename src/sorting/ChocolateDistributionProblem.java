package sorting;

import java.util.Arrays;

/*- Given an arr of chocolate packets and m children.
 * 	Pick m packets from arr ensuring fair distribution (max - min packets is the least)
 * 	Ex. - arr: {7, 3, 2, 4, 9, 12, 56}, m: 3 => 2 (Packets 2, 3, 4).
 */
public class ChocolateDistributionProblem {

	public static void main(String[] args) {
		int[] arr = { 7, 3, 2, 4, 9, 12, 56 };
		System.out.println(distribute(arr, 3));
	}

	private static int distribute(int[] arr, int m) {
		if (m > arr.length)
			return -1;
		Arrays.sort(arr);
		int diff = arr[m - 1] - arr[0];
		for (int i = 1; (i + m - 1) < arr.length; i++) {
			diff = Math.min(arr[i + m - 1] - arr[i], diff);
		}
		return diff;
	}

}
