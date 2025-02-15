package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.ArrayUtils;

public class LexicographicRank {

	public static void main(String[] args) {
		String str = "ABC";
		System.out.println(getLexRankNaive(str));
	}

	static int getLexRankNaive(String str) {
		List<String> perms = new ArrayList<>();
		permute(str.toCharArray(), 0, perms);
		Collections.sort(perms);
		return perms.indexOf(str) >= 0 ? perms.indexOf(str) + 1 : -1;
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
