package mathematics;

// Given two nos. x and n, calculate x^n.
public class Power {

	// T(n): O(n)
	static int getPower(int x, int n) {
		int res = 1;
		for (int i = 0; i < n; i++) {
			res *= x;
		}
		return res;
	}

	// T(n): O(log(n)), S(n): O(log(n))
	static int getPowerRec(int x, int n) {
		if (n == 0)
			return 1;
		int temp = getPowerRec(x, n / 2);
		temp = temp * temp;
		if (n % 2 == 0)
			return temp;
		else
			return temp * x;
	}

	/*- every no. can be written as a sum of powers of 2
	 * 	all n bits can be traveled in O(log(n)) time.
	 * 	T(n): O(log(n))
	 */
	static int getPowerIt(int x, int n) {
		int res = 1;
		while (n > 0) {
			if (n % 2 != 0)
				res *= x;
			x *= x;
			n >>= 1;	// n = n/2
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(getPower(2, 1));
		System.out.println(getPowerIt(4, 5));
	}

}
