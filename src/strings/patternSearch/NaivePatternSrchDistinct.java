package strings.patternSearch;

// Note: Pattern has all distinct characters.
public class NaivePatternSrchDistinct {

	// O(n).
	public static void main(String[] args) {
		String txt = "ABCABCDABCD", pat = "ABCD";

		int m = pat.length(), n = txt.length(), j, i = 0;
		while (i <= n - m) {
			for (j = 0; j < m; j++) {
				if (txt.charAt(i + j) != pat.charAt(j))
					break;
			}
			if (j == m)
				System.out.print(i + " ");
			if (j == 0)
				i++;
			else
				i += j;
		}
	}

}
