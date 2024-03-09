package recursion;

// Given a no. n. Find sum of first n natural nos.
public class SumOfNaturalNumbers {

	static int getSum(int n) {
		return (n * (n + 1)) / 2;
	}

	// T(n): O(n), S(n): O(n)
	static int getSumRecursive(int n) {
		if (n == 0)
			return 0;
		return n + getSumRecursive(n - 1);
	}

	// k is an accumulator parameter initialized with 0.
	static int getSumTailRecursive(int n, int k) {
		if (n == 0)
			return k;
		return getSumTailRecursive(n - 1, k + n);
	}

	public static void main(String[] args) {
		System.out.println(getSumTailRecursive(5, 0)); // k=0 initially.
	}

}
