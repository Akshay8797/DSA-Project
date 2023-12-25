package mathematics;

/*- Given an int n >= 0. FInd the trailing zeroes in the number
 * Ex: 	I/P: n=5	=>	O/P: 1.
 * 		I/P: n=10	=> 	O/P: 2.
 */

public class TrailingZeroesInFactorial {

	/*- Count (2,5) pairs in the prime factorization. 
	 * no. of 2's > no. of 5's => count no. of 5's
	 * trailing zeroes count = n/5 + n/25 + n/125 + ...
	 * T(n): O(log n)
	 */
	static int countTrailingZeroes(int n) {
		int res = 0;
		for (int i = 5; i <= n; i *= 5)
			res = res + (n / i);
		return res;
	}

	public static void main(String[] args) {
		System.out.println(countTrailingZeroes(10));
	}

}
