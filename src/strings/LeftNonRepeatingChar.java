package strings;

import java.util.Arrays;

import utils.Constants;

//Given a String, find the index of the left-most non-repeating character.
public class LeftNonRepeatingChar {

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		System.out.println(leftMostNonRepeatingEff(str));
	}

	// T(n): O(n).
	static int leftMostNonRepeating(String str) {
		int[] freq = new int[Constants.ALL_WORDS];
		for (int i = 0; i < str.length(); i++)
			freq[str.charAt(i) - 'A']++;
		for (int i = 0; i < str.length(); i++) {
			if (freq[str.charAt(i) - 'A'] == 1)
				return i;
		}
		return -1;
	}

	// T(n): O(n).
	static int leftMostNonRepeatingEff(String str) {
		int[] freq = new int[Constants.ALL_WORDS];
		Arrays.fill(freq, -1);
		for (int i = 0; i < str.length(); i++) {
			int currChar = str.charAt(i) - 'A';
			if (freq[currChar] == -1)
				freq[currChar] = i;
			else
				freq[currChar] = -2;
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < Constants.ALL_WORDS; i++) {
			if (freq[i] >= 0)
				res = Math.min(freq[i], res);
		}
		return (res == Integer.MAX_VALUE) ? -1 : res;
	}

}
