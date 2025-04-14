package stack.inPrePostfix;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

//Given an Infix expression containing alphabets and operators, convert it to Prefix expression.
public class InfixToPrefix {

	private static class Conversion {
		private Deque<Character> stack;
		private StringBuilder res;
		private Map<Character, Integer> precedence = Map.of('+', 1, '-', 1, '*', 2, '/', 2, '^', 3);

		Conversion(int cap) {
			stack = new ArrayDeque<>(cap); // Stores the operators and ')'.
			res = new StringBuilder(cap);
		}

		public boolean notGreater(char ch) {
			if (stack.isEmpty())
				return false;
			Integer currPrecedence = precedence.get(ch);
			Integer stkPrecedence = precedence.get(stack.peek());
			if (currPrecedence != null && stkPrecedence != null) {
				if (currPrecedence == stkPrecedence && ch == '^')
					return false; // Case for right associative '^' operator.
				else
					return currPrecedence <= stkPrecedence;
			}
			return false;
		}

		// Method to convert an infix expression to a prefix expression.
		public String infixToPrefix(String exp) {
			for (int i = exp.length() - 1; i >= 0; i--) { // Traverse in reverse.
				char ch = exp.charAt(i);
				if (Character.isLetter(ch)) // If operand, append to output.
					res.append(ch);
				else if (ch == ')')
					stack.push(ch); // If ')', push to the stack.
				// If '(', pop and append to output until ')' is encountered.
				else if (ch == '(') {
					while (!stack.isEmpty() && stack.peek() != ')') {
						res.append(stack.pop());
					}
					if (stack.isEmpty() || stack.peek() != ')') {
						return "Invalid expression: Mismatched parentheses!";
					}
					stack.pop(); // Pop the ')'.
				}
				// If operator, pop lower precedence operators and then push.
				else if (precedence.containsKey(ch)) {
					while (!stack.isEmpty() && notGreater(ch)) {
						res.append(stack.pop());
					}
					stack.push(ch);
				}
			}
			// Pop operators from stack and append to output after the expression is traversed.
			while (!stack.isEmpty()) {
				if (stack.peek() == ')' || stack.peek() == '(') {
					return "Invalid expression: Mismatched parentheses!";
				}
				res.append(stack.pop());
			}
			return res.reverse().toString(); // reverse the output string.
		}
	}

	public static void main(String[] args) {
		String exp = "(a-b/c)*x+y";
		Conversion conversion = new Conversion(exp.length());
		System.out.println(conversion.infixToPrefix(exp));
	}

}
