package strings;

/*- Give 2 Strings s1 and s2, check if s2 is a subsequence of s1.
 * 	Subsequence of a String is derived by removing 0 or more characters 
 * 	without changing the relative order of the remaining characters.
 * 	For a String of length n there can be 2^n subsequences.
 */
public class Subsequence {

	public static void main(String[] args) {
		String s1 = "ABCDEF", s2 = "ADE";
		System.out.println(IsSubsequence(s1, s2));
	}

	// T(n): O(n1).
	private static boolean IsSubsequence(String s1, String s2) {
		int n1 = s1.length(), n2 = s2.length(), i2 = 0;
		if (n2 == 0)
			return true;
		if (n2 > n1)
			return false;
		for (int i1 = 0; i1 < n1 && i2 < n2; i1++) {
			if (s1.charAt(i1) == s2.charAt(i2))
				i2++;
		}
		return i2 == n2;
	}

}
