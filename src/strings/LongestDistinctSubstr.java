package strings;

import utils.Constants;

/*- Given a string, find the longest substring with distinct characters.
 *  str = "abcdabc" => 4 ("cdab").
 */
public class LongestDistinctSubstr {

	public static void main(String[] args) {
		String str = "abcdabce";
		System.out.println(getLongestDistSubstrNaive(str));
	}

	// T(n): O(n^3) - Generate all substrings.
	private static int getLongestDistSubstrNaive(String str) {
		int n = str.length(), len = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (areDistinct(str, i, j))
					len = Math.max(len, j - i + 1);
			}
		}
		return len;
	}

	// checks if i-j have distinct chars.
	private static boolean areDistinct(String str, int i, int j) {
		boolean[] visited = new boolean[Constants.ALL_CHARS];
		for (int k = i; k <= j; k++) {
			if (visited[str.charAt(k)])
				return false;
			visited[str.charAt(k)] = true;
		}
		return true;
	}

}
