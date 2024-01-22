package bitMagic;

/*- Given an int[]. All nos. appear even times except one.
 * 	I/P: arr[] = [4,3,4,4,4,5,5]
 * 	O/P: 3
 */

public class OneOddOccurring {

	// T(n): O(n^2)
	static int findOneOddOccurring(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (arr[i] == arr[j])
					count++;
			}
			if ((count & 1) != 0) // (count % 2) != 0
				return arr[i];
		}
		return -1;
	}

	/*- x^0 = x
	 * 	x^x = 0
	 * 	T(n): O(n)
	 */
	static int findOneOddOccurringUsingXor(int[] arr, int n) {
		int res = arr[0];
		for (int i = 1; i < n; i++) {
			res = res ^ arr[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] input = { 4, 3, 4, 4, 4, 5, 5 };
		System.out.println(findOneOddOccurring(input, input.length));
		System.out.println(findOneOddOccurringUsingXor(input, input.length));

	}

}
