package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mathematics.Factorial;
import utils.ArrayUtils;
import utils.Constants;

public class LexicographicRank {

	public static void main(String[] args) {
		String str = "BBA";
		System.out.println(getLexRank(str));
	}

	/*- T(n): O(n). 
	 * 	Mul /= factorial(count[str.charAt(i)]) - If str has duplicates.
	 */
	private static int getLexRank(String str) {
		int n = str.length(), mul = Factorial.fact(n), res = 1;
		int[] count = new int[Constants.ALL_CHARS];
		for (int i = 0; i < n; i++) {
			count[str.charAt(i)]++; // freq array.
		}
		for (int i = 1; i < Constants.ALL_CHARS; i++) {
			count[i] += count[i - 1]; // cumulative count to get count of smaller chars.
		}
		for (int i = 0; i < n - 1; i++) {
			mul = mul / (n - i);
			res = res + count[str.charAt(i) - 1] * mul;
			// set correct count on the right of str.charAt(i).
			for (int j = str.charAt(i); j < Constants.ALL_CHARS; j++)
				count[j]--;
		}
		return res;
	}

	// T(n): O(n!), S(n): O(n!).
	static int getLexRankNaive(String str) {
		List<String> perms = new ArrayList<>();
		permute(str.toCharArray(), 0, perms);
		Collections.sort(perms);
		return perms.indexOf(str) + 1;
	}

	private static void permute(char[] chars, int idx, List<String> perms) {
		int n = chars.length;
		if (idx == n - 1) {
			perms.add(String.valueOf(chars));
			return;
		}
		for (int i = idx; i < n; i++) {
			ArrayUtils.swapChar(chars, idx, i);
			permute(chars, idx + 1, perms);
			ArrayUtils.swapChar(chars, idx, i);
		}
	}

}
