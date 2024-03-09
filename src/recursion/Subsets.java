package recursion;

/*- Given a String s of length n. Generate all the subsets of s.
 * 	Assume all characters in s are distinct.
 * 	For a String of length n, there will be 2^n subsets.
 *	I/P: s="AB" => O/P: "", "A", "B", "AB".	
 */

public class Subsets {

	static void generateSubsets(String s, String curr, int index) {
		if (index == s.length()) {
			System.out.println(curr);
			return;
		}
		generateSubsets(s, curr, index + 1);
		generateSubsets(s, curr + s.charAt(index), index + 1);
	}

	public static void main(String[] args) {
		generateSubsets("ABC", "", 0);
	}

}
