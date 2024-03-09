package recursion;

public class SumOfDigits {

	// T(n): O(d), S(n): O(d) [d: digits in n].
	static int getDigitSumRecursive(int n) {
		if (n == 0)
			return 0;
		return (n % 10) + getDigitSumRecursive(n / 10);
	}

	// s is an accumulator parameter initialized with 0.
	static int getDigitSumTailRecursive(int n, int s) {
		if (n == 0)
			return s;
		return getDigitSumTailRecursive(n / 10, s + (n % 10));
	}

	public static void main(String[] args) {
		System.out.println(getDigitSumRecursive(9987));
		System.out.println();
		System.out.println(getDigitSumTailRecursive(253, 0)); // s=0 initially.
	}

}
