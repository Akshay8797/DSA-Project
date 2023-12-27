package mathematics.problems;

public class DigitsInFactorial {

	/*- no. of digits in a no. = floor(log10(x))+1
	 * 	no. of digits in n! = floor(log10(1) + log10(2) + log10(3) + ... + log10(n))+1
	 * 	T(n): O(n)
	 */
	static int getDigits(int n) {
		double digitSum = 0;
		for (int i = 2; i <= n; i++)
			digitSum += Math.log10(i);
		return (int) (1 + Math.floor(digitSum));
	}

	public static void main(String[] args) {
		System.out.println(getDigits(42));
	}

}
