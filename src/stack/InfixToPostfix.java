package stack;

import java.util.Map;

public class InfixToPostfix {

	private static class Conversion {
		private int top = -1;
		private char[] stack;
		private StringBuilder res = new StringBuilder();
		private Map<Character, Integer> precedence = Map.of('+', 1, '-', 1, '*', 2, '/', 2, '^', 3);

		Conversion(int cap) {
			stack = new char[cap];
		}

		public boolean isEmpty() {
			return (top == -1);
		}

		public char peek() {
			return stack[top];
		}

		public char pop() {
			if (!isEmpty()) {
				return stack[top--];
			} else {
				return '$'; // To indicate the stack is empty.
			}
		}

		public void push(char op) {
			stack[++top] = op;
		}

		public boolean isOperand(char ch) {
			return Character.isLetter(ch);
		}

		public boolean notGreater(char i) {
			if (isEmpty())
				return false;
			Integer currentPrecedence = precedence.get(i);
			Integer stackPrecedence = precedence.get(peek());
			return currentPrecedence != null && stackPrecedence != null && currentPrecedence <= stackPrecedence;
		}

		// Method to convert an infix expression to a postfix expression.
		public void infixToPostfix(String exp) {
			for (int i = 0; i < exp.length(); i++) {
				char ch = exp.charAt(i);
				// If the character is an operand, append it to the output.
				if (isOperand(ch)) {
					res.append(ch);
				}
				// If the character is '(', push it to the stack.
				else if (ch == '(') {
					push(ch);
				}
				// If the character is ')', pop and append to output until '(' is encountered.
				else if (ch == ')') {
					while (!isEmpty() && peek() != '(') {
						res.append(pop());
					}
					if (!isEmpty() && peek() != '(') {
						System.out.println("Invalid expression"); // If no matching '('.
						return;
					} else {
						pop(); // Pop the '('.
					}
				}
				// If the character is an operator.
				else {
					while (!isEmpty() && notGreater(ch)) {
						res.append(pop());
					}
					push(ch);
				}
			}
			// Pop all the operators from the stack and append to output after the exp is
			// traversed.
			while (!isEmpty()) {
				res.append(pop());
			}
			System.out.println(res);
		}
	}

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		Conversion conv = new Conversion(exp.length());
		conv.infixToPostfix(exp);
	}

}
