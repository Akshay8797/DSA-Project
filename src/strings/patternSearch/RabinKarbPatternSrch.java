package strings.patternSearch;

public class RabinKarbPatternSrch {

	static final int d = 128; // character set size for weighted sum.
	static final int q = 509; // prime for modulo computation.

	public static void main(String[] args) {
		String txt = "ABCABCDABCD", pat = "ABCD";
		doRabinKarpSearch(txt, pat);
	}

	// T(n): O((n-m)*m) - when pat is present at all the pos, but works better generally.
	private static void doRabinKarpSearch(String txt, String pat) {
		int h = 1, m = pat.length(), n = txt.length();
		// (d^(n-1)) % q - computation for next hash calculation.
		for (int i = 0; i < m - 1; i++)
			h = (h * d) % q;

		int p = 0, t = 0;
		// Initial pattern and text window hash computation.
		for (int i = 0; i < m; i++) {
			p = (p * d + pat.charAt(i)) % q;
			t = (t * d + txt.charAt(i)) % q;
		}

		for (int i = 0; i <= n - m; i++) {
			if (p == t) {
				// Check for spurious hit.
				boolean flag = true;
				for (int j = 0; j < m; j++) {
					if (txt.charAt(i + j) != pat.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag)
					System.out.print(i + " ");
			}
			if (i < n - m) {
				// Next hash value for the text window.
				t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;
				if (t < 0)
					t = t + q; // (-t % q) = (t + q)
			}
		}
	}

}
