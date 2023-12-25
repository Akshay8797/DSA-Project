package mathematics;

/*- Given an int n > 0 check if it is Palindrome or not.
 * Palindrome: If its reverse is same as the original number.
 */

public class Palindrome {

	// T(n) = O(d) [d : no. of digits].
	static boolean isPalindrome(int n) {
		int num = n, digit = 0, rev = 0;
		while (n != 0) {
			digit = n % 10;
			rev = rev * 10 + digit;
			n /= 10;
		}
		return rev == num;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(4554));
	}

}
