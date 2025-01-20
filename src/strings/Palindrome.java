package strings;

public class Palindrome {

	// T(n): O(n).
	public static void main(String[] args) {
		String str = "ABCDCBA";
		int left = 0, right = str.length() - 1;
		boolean isPal = true;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				isPal = false;
				break;
			}
			left++;
			right--;
		}
		System.out.println(isPal);
	}

}
