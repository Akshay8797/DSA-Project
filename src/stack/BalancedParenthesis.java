package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/*- Given an input string with only 6 possible characters: (,),{,},[, and ]. 
 * 	Check if the parenthesis are balanced.
 * 	Ex: "{}([()])" => true.
 */
public class BalancedParenthesis {

	public static void main(String[] args) {
		String str = "{}([()])";
		System.out.println(isBalanced(str));
	}

	// T(n): O(n), S(n): O(n).
	private static boolean isBalanced(String str) {
		List<Character> closings = List.of(')', '}', ']');
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if (closings.contains(ch)) {
				if (stack.isEmpty())
					return false;
				Character open = stack.pop();
				if ((open.equals('(') && !ch.equals(')')) || (open.equals('{') && !ch.equals('}'))
						|| (open.equals('[') && !ch.equals(']')))
					return false;
			} else
				stack.push(ch);
		}
		return stack.isEmpty();
	}

}
