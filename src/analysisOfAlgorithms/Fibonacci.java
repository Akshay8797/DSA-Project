package analysisOfAlgorithms;

public class Fibonacci {

	/*- T(n) = O(2^n) 
	 * 	S(n) = O(n)
	 */
	static int fibRecursive(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fibRecursive(n - 1) + fibRecursive(n - 2);
	}

	/*- T(n) = O(n) 
	 * 	S(n) = O(n)
	 */
	static int fibUsingArray(int n) {
		int[] fib = new int[n + 1];
		fib[1] = 1; // since fib[0] is already 0, so not assigning it
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

	/*- T(n) = O(n) 
	 * 	S(n) = O(1)
	 */
	static int fibWithoutArray(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int a = 0, b = 1;
		for (int i = 2; i <= n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	public static void main(String[] args) {
		System.out.println(fibRecursive(4));
	}

}
