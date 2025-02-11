package strings;

import utils.Constants;

/*- 0-9: 48-57, A-Z: 65-90, a-z: 97-122 
 * 	Given a string of lower case characters. Print the frequencies in sorted order of characters.
 */
public class PrintFreq {

	// T(n): O(n)
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		int[] count = new int[Constants.SMALL_WORDS];
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (count[i] > 0)
				System.out.println((char) ('a' + i) + " : " + count[i]);
		}
	}

}
