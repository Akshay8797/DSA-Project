package strings;

/*- Given two strings - s1 and s2, check if they are rotations of each other.
 * 	Check if s2 can be obtained from s1 by rotating it (left or right) any no. of times.
 * 	A left rotation by k places shifts the first k characters of s1​ to the end.
 * 	Note: Left rotation by k is equivalent to Right rotation of len-k.
 */
public class Rotations {

	public static void main(String[] args) {
		String s1 = "ABCD", s2 = "CDAB";
		System.out.println(areRotationsEff(s1, s2));
	}

	// T(n): O(n^2).
	static boolean areRotations(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		for (int i = 0; i < s1.length(); i++) {
			s1 = s1.substring(1) + s1.charAt(0); // left rotate.
			if (s2.equals(s1)) {
				return true;
			}
		}
		return false;
	}

	// T(n): O(n).
	private static boolean areRotationsEff(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		return ((s1 + s1).indexOf(s2) >= 0); // similar to pattern searching.
	}

}
