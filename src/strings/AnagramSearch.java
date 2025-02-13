package strings;

import java.util.Arrays;

import utils.Constants;

/*- Given a txt and pat, check if pat or any of its permutations (Anagram) is present in the txt.
 * 	Ex: txt = "geeksforgeeks", pat = "frog" => true (forg)
 */
public class AnagramSearch {

	public static void main(String[] args) {
		String txt = "geeksforgeeks", pat = "frog";
		System.out.println(isAnagramPresent(txt, pat));
	}

	// T(n): O(n).
	private static boolean isAnagramPresent(String txt, String pat) {
		int[] cntTxt = new int[Constants.ALL_CHARS], cntPat = new int[Constants.ALL_CHARS];
		int n = txt.length(), m = pat.length();
		for (int i = 0; i < m; i++) {
			cntTxt[txt.charAt(i)]++;
			cntPat[pat.charAt(i)]++;
		}
		for (int i = m; i < n; i++) {
			if (Arrays.equals(cntTxt, cntPat))
				return true;
			cntTxt[txt.charAt(i)]++;
			cntTxt[txt.charAt(i - m)]--;
		}
		return false;
	}

}
