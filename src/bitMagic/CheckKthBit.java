package bitMagic;

/*- Given two nos. n and k. Check if kth bit is set or not.
 * 	I/P: n=5 : 0...0101 ; k=1
 * 	O/P: true
 */

public class CheckKthBit {

	/*- Bitwise and with no. having only kth bit set => 2^(k-1)
	 * 	T(n) = O(k)
	 */
	static boolean checkKthBit(int n, int k) {
		int x = 1;
		for (int i = 0; i < (k - 1); i++) {
			x *= 2;
		}
		if ((n & x) != 0)
			return true;
		return false;
	}

	static boolean checkKthBitUsingLS(int n, int k) {
		int x = (1 << (k - 1));
		if ((n & x) != 0)
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(checkKthBit(5, 3));
		System.out.println(checkKthBitUsingLS(5, 1));
	}

}
