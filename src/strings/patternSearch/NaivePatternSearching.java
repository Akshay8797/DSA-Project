package strings.patternSearch;

/*- Given two strings, find the occurrence(s) of the pattern in the string.
 * 	Ex: text: ABBBBBCD, pat: BBB => 1 2 3
 */
public class NaivePatternSearching {

	// T(n): O((m-n)*n)
	public static void main(String[] args) {
		String txt = "ABABABCD", pat = "ABAB";

		int m = txt.length(), n = pat.length(), j;
		for (int i = 0; i <= m - n; i++) {
			for (j = 0; j < n; j++) {
				if (txt.charAt(i + j) != pat.charAt(j))
					break;
			}
			if (j == n)
				System.out.print(i + " ");
		}
	}

}
