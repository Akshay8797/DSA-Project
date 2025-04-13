package stack.inPrePostfix;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.MathUtils;

/*- Given a Postfix expression containing operands and operators separated by spaces, Evaluate it.
 * 	Ex: 3 2 * 5 7 * + 9 - => ((3 * 2) + (5 * 7 )) - 9 => (6 + 35) - 9 => 32. 
 */
public class PostfixEvaluation {

	private static class Evaluation {
		private Deque<Integer> stack;

		Evaluation(int cap) {
			stack = new ArrayDeque<>(cap);
		}

		int evaluatePostfix(String exp) {
			String[] tokens = exp.split(" ");
			for (int i = 0; i < tokens.length; i++) {
				String str = tokens[i];
				if (str.isEmpty())
					continue;
				else if (str.matches("\\d+")) // Matches numbers.
					stack.push(Integer.valueOf(str));
				else {
					if (stack.size() < 2)
						throw new IllegalArgumentException("Not enough operands!");
					int b = stack.pop(), a = stack.pop();
					int res = MathUtils.calculateExpr(a, b, str);
					stack.push(res);
				}
			}
			return stack.pop(); // Return the res.
		}
	}

	public static void main(String[] args) {
		String exp = "3 2 * 5 7 * + 9 -";
		Evaluation eval = new Evaluation(exp.length());
		try {
			System.out.println(eval.evaluatePostfix(exp));
		} catch (Exception e) {
			System.err.println("Error evaluating postfix: " + e.getMessage());
		}
	}

}
