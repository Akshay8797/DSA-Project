package mathematics;

/*- Given a no. n, find prime factors of n
 * prime factors: divisors of the no. which are primes.
 * Ex:	I/P: a=12	=>	O/P: 2,2,3
 * 		I/P: a=13	=>	O/P: 13
 */

public class PrimeFactors {

	// T(n): O(n*sqrt(n)*log(n))
	static void getPrimeFactors(int n) {
		if (n <= 1)
			return;
		if (Prime.isPrime(n)) {
			System.out.println(n);
		} else {
			for (int i = 2; i < n / 2; i++) {
				if (Prime.isPrime(i)) {
					int x = i;
					while (n % x == 0) {
						System.out.println(i);
						x = x * i;
					}
				}
			}
		}
	}

	/*- Idea: divisors always appear in pairs => x <= sqrt(n)
	 * 	A no. n can be written as multiplication of powers of prime factors
	 * 	T(n): O(sqrt(n))
	 */
	static void primeFactorsEf1(int n) {
		if (n <= 1)
			return;
		for (int i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				System.out.println(i);
				n = n / i;
			}
		}
		/*- added to print the last prime factor if it has power 1
		 * since no prime factors exists for a prime no.
		 * Ex: 84 = 2^2 * 3 * 7
		 */
		if (n > 1)
			System.out.println(n);
	}

	static void primeFactorsEf2(int n) {
		if (n <= 1)
			return;
		while (n % 2 == 0) {
			System.out.println(2);
			n /= 2;
		}
		while (n % 3 == 0) {
			System.out.println(3);
			n /= 3;
		}
		for (int i = 5; i * i <= n; i += 6) {
			while (n % i == 0) {
				System.out.println(i);
				n = n / i;
			}
			while (n % (i + 2) == 0) {
				System.out.println(i + 2);
				n = n / (i + 2);
			}
		}
		if (n > 3)
			System.out.println(n);
	}

	public static void main(String[] args) {
		getPrimeFactors(12);
		System.out.println();
		primeFactorsEf2(450);
	}

}
