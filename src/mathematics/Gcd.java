package mathematics;

/*- Given 2 nos. a and b. Find the largest no. that divides both.
 * Ex:	I/P: a=4, b=6	=>	O/P: 2
 * 		I/P: a=7, b=13	=>	O/P: 1
 */

public class Gcd {

	// T(n): O(min(a,b))
	static int getGcd(int a, int b) {
		int res = Math.min(a, b);
		while (res > 0) {
			if (a % res == 0 && b % res == 0) {
				break;
			}
			res--;
		}
		return res;
	}

	// let b be smaller than a => gcd(a,b) = gcd(a-b,b)
	static int euclideanGcd(int a, int b) {
		while (a != b) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
		return a; // or b
	}

	/*- Optimized implementation of Euclidean's algorithm avoiding repeated -'s
	 * 	T(n): O(log(min(a,b)))
	 */
	static int moduloGcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return moduloGcd(b, a % b); // swaps a,b when b>a
	}

	public static void main(String[] args) {
		System.out.println(getGcd(6, 8));
	}

}
