package stack.inPrePostfix;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

// Given an Infix expression, convert it to postfix expression.
public class InfixToPostfix {

	private static class Conversion {
		private Deque<Character> stack;
		private StringBuilder res = new StringBuilder();
		private Map<Character, Integer> precedence = Map.of('+', 1, '-', 1, '*', 2, '/', 2, '^', 3);

		Conversion(int cap) {
			stack = new ArrayDeque<>(cap); // stores the operators and '('.
		}

		public boolean isOperand(char ch) {
			return Character.isLetterOrDigit(ch);
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

		// Method to convert an infix expression to a postfix expression.
		public String infixToPostfix(String exp) {
			for (int i = 0; i < exp.length(); i++) {
				char ch = exp.charAt(i);
				if (isOperand(ch)) {
					res.append(ch); // If ch is an operand, append it to the output.
				} else if (ch == '(') {
					stack.push(ch); // If ch is '(', push to the stack.
				}
				// If the character is ')', pop and append to output until '(' is encountered.
				else if (ch == ')') {
					while (!stack.isEmpty() && stack.peek() != '(') {
						res.append(stack.pop());
					}
					if (stack.isEmpty() || stack.peek() != '(') {
						return "Invalid expression: Mismatched parentheses!";
					}
					stack.pop(); // Pop the '('.
				} else if (precedence.containsKey(ch)) { // If ch is an operator.
					while (!stack.isEmpty() && notGreater(ch)) {
						res.append(stack.pop());
					}
					stack.push(ch);
				} else
					return "Invalid expression: Invalid operator!";
			}
			// Pop operators from the stack and append to output after the exp is traversed.
			while (!stack.isEmpty()) {
				res.append(stack.pop());
			}
			return res.toString();
		}
	}

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		Conversion conversion = new Conversion(exp.length());
		System.out.println(conversion.infixToPostfix(exp));
	}
}