package queue;

import java.util.ArrayDeque;
import java.util.Queue;

/*- Given a no. n, print first n nos. (increasing order) such that that all these nos. have digits as 5 or 6.
 * 	n: 4 => 5, 6, 55, 56.
 */
public class GenerateNosWithGivenDigits {

	static void printFirstN(int n) {
		Queue<String> que = new ArrayDeque<>();
		que.offer("5");
		que.offer("6");
		for (int cnt = 0; cnt < n; cnt++) {
			String curr = que.peek();
			System.out.println(que.poll());
			que.offer(curr + 5);
			que.offer(curr + 6);
		}
	}

	public static void main(String[] args) {
		printFirstN(10);
	}

}
