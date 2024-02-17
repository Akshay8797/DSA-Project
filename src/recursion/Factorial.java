package recursion;

public class Factorial {

	static int factorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * factorial(n - 1);
	}

	static int factorialTailrecursive(int n, int k) {
		if (n == 0 || n == 1)
			return k;
		return factorialTailrecursive(n - 1, k * n);
	}

	public static void main(String[] args) {
		System.out.println(factorial(3));
		System.out.println();
		System.out.println(factorialTailrecursive(5, 1)); // k=1 initially
	}

}
