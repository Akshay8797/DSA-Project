package strings;

// Given a String as a character array, reverse the order of words in the String in-place.
public class ReverseWords {

	public static void main(String[] args) {
		String str = "Welcome to My World"; // world my to welcome
		System.out.println("Reversed: " + reverseWords(str.toCharArray()));
	}

	// T(n): O(n) - reverse individual words, then reverse the entire string.
	private static String reverseWords(char[] str) {
		int start = 0, n = str.length;
		for (int end = 1; end < n; end++) {
			if (str[end] == ' ') {
				reverse(str, start, end - 1);
				start = end + 1;
			}
		}
		reverse(str, start, n - 1);
		reverse(str, 0, n - 1);
		return String.valueOf(str);
	}

	private static void reverse(char[] str, int start, int end) {
		while (start < end) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}

}
