package strings.patternSearch;

/*- Given two strings, find the occurrence(s) of the pattern in the string.
 * 	Ex: text: ABBBBBCD, pat: BBB => 1 2 3
 */
public class NaivePatternSearching {

	// T(n): O((n-m)*m).
	public static void main(String[] args) {
		String txt = "ABABABCD", pat = "ABAB";

		int m = pat.length(), n = txt.length(), j;
		for (int i = 0; i <= n - m; i++) {
			for (j = 0; j < m; j++) {
				if (txt.charAt(i + j) != pat.charAt(j))
					break;
			}
			if (j == m)
				System.out.print(i + " ");
		}
	}

}
