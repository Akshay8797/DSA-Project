package strings.patternSearch;

import java.util.Arrays;

/*- Given a string, create LPS array. LPS: Longest Proper Prefix which is also a Suffix.
 *  Used as a pre-processing in KMP algorithm.
 *  For string "abc", Proper prefixes are "", "a", "ab" and the suffixes are "", "c", "bc", "abc".
 *  Ex: str = "abacab", LPS[] = [0, 0, 1, 0, 1, 2, 3, 0].
 */
public class KmpPart1 {

	public static void main(String[] args) {
		String str = "abacab";
		int[] lps = new int[str.length()];
		fillLpsArray(str, lps);
		System.out.println(Arrays.toString(lps));
	}

	// eff - T(n): O(n). Here, len = lps[i - 1].
	static void fillLpsArray(String str, int[] lps) {
		int n = str.length(), len = 0, i = 1;
		while (i < n) {
			if (str.charAt(i) == str.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len == 0) {
					lps[i] = 0;
					i++;
				} else
					// if lps[i-1] cannot be extended, try lps[len-1].
					len = lps[len - 1];
			}
		}
	}

	// naive - T(n): O(n^3)
	static void createLpsArray(String str, int[] lps) {
		for (int i = 0; i < str.length(); i++)
			lps[i] = longPropPreSuffix(str, i + 1);
	}

	private static int longPropPreSuffix(String str, int n) {
		for (int len = n - 1; len > 0; len--) {
			boolean isMatch = true;
			for (int i = 0; i < len; i++) {
				// Prefix char: str.charAt(i), Suffix char: str.charAt(n-len+i)
				if (str.charAt(i) != str.charAt(n - len + i)) {
					isMatch = false;
					break;
				}
			}
			if (isMatch)
				return len;
		}
		return 0;
	}

}
