package bitMagic;

/*- Given a String s. find all the subsets of s.
 * 	I/P: s="abc"
 * 	since, n=3 => 2^3 (2^n) => 8 subsets.
 * 	O/P: "", "a", "b", "ab", "c", "ac", "bc", "abc" 
 */

public class PowerSet {

	/*- 1<<n is similar to 2^n
	 * 	T(n): O((2^n)*n)
	 */
	static void printSubsets(String s) {
		int n = s.length(), powerSize = 1 << n;
		for (int i = 0; i < powerSize; i++) {
			for (int j = 0; j < n; j++)
				if ((i & (1 << j)) != 0)
					System.out.print(s.charAt(j));
			System.out.println();
		}
	}

	public static void main(String[] args) {
		printSubsets("abc");
	}

}
