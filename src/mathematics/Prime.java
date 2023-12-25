package mathematics;

/*- Given a no. n, check if it is Prime.
 * A no. is Prime if its only divisors are the 1 and the no. itself.
 * Ex:	I/P: a=13	=>	O/P: Yes
 * First few primes are 2, 3, 5, 7, 11, 13, 17, 19, ...
 */

public class Prime {

	/*- Divisors always appear in pairs
	 * T(n): O(n^1/2)
	 */
	static boolean isPrime(int n) {
		if (n == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	// almost 3X faster than O(n^1/2)
	static boolean isPrimeEff(int n) {
		if (n == 1)
			return false;
		// added since checking 2 and 3 multiples later
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i <= Math.sqrt(n); i += 6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPrime(4));
	}

}
