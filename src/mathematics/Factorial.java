package mathematics;

/*- Given an int n >= 0. FInd the Factorial of n.
 * Factorial: Multiplication of all numbers from 1 to n.
 */

public class Factorial {

	// T(n): O(n); S(n): O(1).
	public static int fact(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++)
			res = res * i;
		return res;
	}

	// T(n): O(n); S(n): O(n)
	static int factRec(int n) {
		if (n == 1 || n == 0)
			return 1;
		return n * factRec(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(fact(6));
		System.out.println(factRec(5));
	}

}
