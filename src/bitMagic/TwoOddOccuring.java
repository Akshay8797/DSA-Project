package bitMagic;

/*- Given an int[]. All nos. appear even times except two.
 * 	I/P: arr[] = [3,4,3,4,5,4,4,6,7,7]
 * 	O/P: 5,6
 */

public class TwoOddOccuring {

	// T(n): O(n^2)
	static void getTwoOddOccurring(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (arr[i] == arr[j])
					count++;
			}
			if ((count & 1) != 0)
				System.out.println(arr[i]);
		}
	}

	/*- T(n): O(n)
	 * x-1 un-sets the last set bit and all 0's post that are set.
	 * k gives a no. which has only the last set bit of x set.
	 */
	static void getTwoOddOccurings(int[] arr, int n) {
		int x = arr[0];
		for (int i = 1; i < n; i++)
			x = x ^ arr[i];
		int k = (x & (~(x - 1)));
		int res1 = 0, res2 = 0;
		for (int i = 0; i < n; i++) {
			if ((arr[i] & k) != 0)
				res1 ^= arr[i];
			else
				res2 ^= arr[i];
		}
		System.out.println(res1 + " " + res2);
	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 3, 4, 5, 4, 4, 6, 7, 7 };
		getTwoOddOccurring(arr, arr.length);
		getTwoOddOccurings(arr, arr.length);
	}

}
