package mathematics;

/*- Given 2 nos. a and b. Find the smallest no. that is divisible both.
 * Ex:	I/P: a=4, b=6	=>	O/P: 12
 * 		I/P: a=7, b=3	=>	O/P: 21
 */

public class Lcm {

	// T(n): O(a*b)
	static int getLcm(int a, int b) {
		int res = Math.max(a, b);
		for (; res <= a * b; res++) {
			if (res % a == 0 && res % b == 0)
				break;
		}
		return res;
	}

	/*- a*b = gcd(a,b) * lcm(a,b)
	 * 	T(n): O(log(min(a,b)))
	 */
	static int getLcmUsingHcf(int a, int b) {
		return (a * b) / Gcd.moduloGcd(a, b);
	}

	public static void main(String[] args) {
		System.out.println(getLcm(4, 6));
	}

}
