package mathematics.problems;

import mathematics.Prime;

/*- Given a +ve int n, find nos. <= n having exactly 3 divisors
 * 	Hence, find perfect squares of primes <= n
 * 	Ex: I/P: n=6	=>	O/P: 1	(which is 4)
 */

public class ThreeDivisors {

	/*- if p is a prime then p^2 will have exactly 3 divisors
	 * 	T(n): O(n^(1/2) * n^(1/4))
	 */
	static int exactly3Divisors(int n) {
		int res = 0;
		for (int i = 2; i * i <= n; i++) {
			if (Prime.isPrime(i))
				res++;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(exactly3Divisors(10));
	}

}
