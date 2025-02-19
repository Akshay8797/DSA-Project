package strings;

import java.util.Arrays;

import utils.Constants;

/*- Given a string, find the longest substring with distinct characters.
 *  str = "abcdabc" => 4 ("cdab").
 */
public class LongestDistinctSubstr {

	public static void main(String[] args) {
		String str = "abcadbd";
		System.out.println(getLongestDistSubstrEff(str));
	}

	// T(n): O(n).
	private static int getLongestDistSubstrEff(String str) {
		int n = str.length(), len = 0, i = 0; // i: start indx of substring.
		int[] prev = new int[Constants.ALL_CHARS];
		Arrays.fill(prev, -1);
		for (int j = 0; j < n; j++) { // j: end indx one after another.
			i = Math.max(i, prev[str.charAt(j)] + 1);
			int maxEnd = j - i + 1;
			len = Math.max(len, maxEnd);
			prev[str.charAt(j)] = j;
		}
		return len;
	}

	// T(n): O(n^2).
	static int getLongestDistSubstrBetter(String str) {
		int n = str.length(), len = 0;
		for (int i = 0; i < n; i++) {
			boolean[] visited = new boolean[Constants.ALL_CHARS];
			for (int j = i; j < n; j++) {
				if (visited[str.charAt(j)])
					break;
				len = Math.max(len, j - i + 1);
				visited[str.charAt(j)] = true;
			}
		}
		return len;
	}

	// T(n): O(n^3) - Generate all substrings.
	static int getLongestDistSubstrNaive(String str) {
		int n = str.length(), len = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!areDistinct(str, i, j)) // not distinct, move to next i.
					break;
				len = Math.max(len, j - i + 1);
			}
		}
		return len;
	}

	// checks if i-j have distinct chars.
	static boolean areDistinct(String str, int i, int j) {
		boolean[] visited = new boolean[Constants.ALL_CHARS];
		for (int k = i; k <= j; k++) {
			if (visited[str.charAt(k)])
				return false;
			visited[str.charAt(k)] = true;
		}
		return true;
	}

}
