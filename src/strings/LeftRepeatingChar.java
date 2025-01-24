package strings;

import utils.Constants;

// Given a String find the index of the left-most repeating character.

/*- ASCII values: 
 * 	0-9: 48-57, A-Z: 65-90, a-z: 97-122 
 * 	Given a string of lower case characters. Print the frequencies in sorted order of characters.
 */
public class LeftRepeatingChar {

	public static void main(String[] args) {
		String str = "abccb";
		System.out.println(leftMostRepeatingEff(str));
	}

	// T(n): O(n).
	static int leftMostRepeating(String str) {
		int[] freq = new int[Constants.ALL_WORDS];
		int n = str.length();
		for (int i = 0; i < n; i++)
			freq[str.charAt(i) - 'A']++;
		for (int i = 0; i < n; i++) {
			if (freq[str.charAt(i) - 'A'] > 1)
				return i;
		}
		return -1;
	}

	// T(n): O(n).
	static int leftMostRepeatingEff(String str) {
		boolean[] visited = new boolean[Constants.ALL_WORDS];
		int res = -1;
		for (int i = str.length() - 1; i >= 0; i--) {
			int charIndx = str.charAt(i) - 'A';
			if (visited[charIndx])
				res = i;
			else
				visited[charIndx] = true;
		}
		return res;
	}

}
