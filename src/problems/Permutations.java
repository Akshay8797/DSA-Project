package problems;

// For a string of length n. The permutations are n!.
public class Permutations {

	static void printPermutations(String s, String ans) {
		if (s.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String ros = s.substring(0, i) + s.substring(i + 1);
			printPermutations(ros, ans + ch);
		}
	}

	public static void main(String[] args) {
		printPermutations("ABC", "");
	}

}
