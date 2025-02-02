package strings.patternSearch;

// Note: Pattern has all distinct characters.
public class NaivePatternSrchDistinct {

	// O(n).
	public static void main(String[] args) {
		String txt = "ABCABCDABCD", pat = "ABCD";

		int m = txt.length(), n = pat.length(), j, i = 0;
		while (i <= m - n) {
			for (j = 0; j < n; j++) {
				if (txt.charAt(i + j) != pat.charAt(j))
					break;
			}
			if (j == n)
				System.out.print(i + " ");
			if (j == 0)
				i++;
			else
				i += j;
		}
	}

}
