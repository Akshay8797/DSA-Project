package recursion;

// 0, 1, 1, 2, 3, 5, 8, 13, ...
public class Fibonacci {

	static int fibonacci(int n) {
		if (n == 0 || n == 1)
			return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	static int fibonacciTailRecursive(int n, int a, int b) {
		if (n == 0)
			return a;
		return fibonacciTailRecursive(n - 1, b, a + b);
	}

	public static void main(String[] args) {
		System.out.println(fibonacci(4));
		System.out.println();
		System.out.println(fibonacciTailRecursive(5, 0, 1)); // a=0, b=1 initially.
	}

}
