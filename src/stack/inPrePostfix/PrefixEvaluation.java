package stack.inPrePostfix;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.MathUtils;

/*- Given a Prefix expression containing operands and operators separated by spaces, Evaluate it.
 * 	Ex: * + 10 2 3 => ((10 + 2) * 3) => 36.
 */
public class PrefixEvaluation {

	private static class Evaluation {
		private Deque<Integer> stack;

		Evaluation(int cap) {
			stack = new ArrayDeque<>(cap);
		}

		int evaluatePrefix(String exp) {
			String[] tokens = exp.split(" ");
			for (int i = tokens.length - 1; i >= 0; i--) { // Traverse in reverse.
				String str = tokens[i];
				if (str.isEmpty())
					continue;
				else if (str.matches("\\d+")) // Matches numbers.
					stack.push(Integer.valueOf(str));
				else {
					if (stack.size() < 2)
						throw new IllegalArgumentException("Not enough operands!");
					int a = stack.pop(), b = stack.pop();
					int res = MathUtils.calculateExpr(a, b, str);
					stack.push(res);
				}
			}
			return stack.pop(); // Return the res.
		}
	}

	public static void main(String[] args) {
		String exp = "^ 10 ^ 2 3";
		Evaluation eval = new Evaluation(exp.length());
		try {
			System.out.println(eval.evaluatePrefix(exp));
		} catch (Exception e) {
			System.err.println("Error evaluating postfix: " + e.getMessage());
		}
	}

}
