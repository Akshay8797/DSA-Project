package recursion;

/*- Given a rope of length n. Cut the rope into maximum no. of pieces such that,
 * 	each piece has either length as a, or b, or c. Hence, 0 < a, b, c <= n
 * 
 * 	I/P: n=5, a=2, b=5, c=1 	=> 	O/P: 5
 * 	I/P: n=23, a=12, b=9, c=11 	=> 	O/P: 2
 *	I/P: n=5, a=4, b=2, c=16 	=> 	O/P: -1
 */

public class RopeCuttingProblem {

	// T(n): O(3^n)
	static int cutRope(int n, int a, int b, int c) {
		if (n == 0)
			return 0;
		if (n < 0)
			return -1;
		int result = FindMax(cutRope(n - a, a, b, c), cutRope(n - b, a, b, c), cutRope(n - c, a, b, c));
		if (result == -1)
			return -1;
		return result + 1;
	}

	static int FindMax(int a, int b, int c) {
		return (a > b) ? (a > c ? a : c) : (b > c ? b : c);
	}

	public static void main(String[] args) {
		System.out.println(cutRope(5, 2, 5, 1));
	}

}
