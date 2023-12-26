package mathematics;

import java.util.Arrays;

/*- Given an int n. print all primes smaller or equal to n.
 * Ex: 	I/P: 10		=>	O/P: 2,3,5,7
 * 		I/P: 23		=>	O/P: 2,3,5,7,11,13,17,19,23
 */

public class SieveOfEratosthenes {

	// T(n): O(n*sqrt(n))
	static void getPrimes(int n) {
		for (int i = 2; i <= n; i++) {
			if (Prime.isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	// T(n): O(n*log(log(n)))
	static void getPrimesEf1(int n) {
		Boolean[] primes = new Boolean[n + 1];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = null;

		for (int i = 2; i * i <= n; i++) {
			if (primes[i]) {
				for (int j = 2 * i; j <= n; j += i)
					primes[j] = false;
			}
		}
		for (int i = 2; i <= n; i++) {
			if (primes[i])
				System.out.println(i);
		}
	}

	/*- An even efficient method is to replace 2*i by i*i
	 * 	since every composites less than i^2 is like i*(i-1), i*(i-2)...
	 */
	static void getPrimesEf2(int n) {
		Boolean[] primes = new Boolean[n + 1];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = null;

		for (int i = 2; i <= n; i++) {
			if (primes[i]) {
				System.out.println(i);
				for (int j = i * i; j <= n; j += i)
					primes[j] = false;
			}
		}

	}
	
	public static void main(String[] args) {
		getPrimes(10);
		System.out.println();
		getPrimesEf2(50);
	}

}
