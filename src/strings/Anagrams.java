package strings;

/*- Given 2 strings, find if they are Anagram.
 * 	Anagram are two strings which are permutations of each other. 
 */
public class Anagrams {

	public static void main(String[] args) {
		String s1 = "listen", s2 = "silent";
		System.out.println(IsAnagrams(s1, s2));
	}

	// T(n): O(n).
	private static boolean IsAnagrams(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		int[] freq = new int[PrintFreq.LOWER_CASE_WORDS];
		for (int i = 0; i < s1.length(); i++) {
			freq[s1.charAt(i) - 'a']++;
			freq[s2.charAt(i) - 'a']--;
		}
		for (int count : freq) {
			if (count != 0)
				return false;
		}
		return true;
	}

}
