package strings.patternSearch;

// KMP string matching algorithm.
public class KmpPart2 {

	public static void main(String[] args) {
		String txt = "ababcababaad", pat = "ababa";
		kmp(txt, pat);
	}

	// T(n): O(n).
	private static void kmp(String txt, String pat) {
		int m = pat.length(), n = txt.length();
		int[] lps = new int[m];
		KmpPart1.fillLpsArray(pat, lps);
		int i = 0, j = 0; // j is always <= n.
		while (i < n) {
			if (pat.charAt(j) == txt.charAt(i)) {
				i++;
				j++;
			}
			if (j == m) {
				System.out.println(i - j);
				j = lps[j - 1];
			} else if (i < n && pat.charAt(j) != txt.charAt(i)) {
				if (j == 0)
					i++;
				else
					j = lps[j - 1];
			}
		}
	}

}
