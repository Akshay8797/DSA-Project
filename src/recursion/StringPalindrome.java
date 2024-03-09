package recursion;

public class StringPalindrome {

	// T(n): O(n), S(n): O(n) [n: length of s].
	static boolean isPalindrome(String s, int start, int end) {
		if (start >= end)
			return true;
		return (s.charAt(start) == s.charAt(end)) && isPalindrome(s, ++start, --end);
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("abcba", 0, 4));
	}

}
