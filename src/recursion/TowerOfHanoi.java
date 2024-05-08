package recursion;

/*- Given 3 towers. A, B, and C. There are certain discs placed in A.
 * 	We need to move discs from A to C in the same order. B can be used as an auxiliary.
 * 	Rules: One disc moves at a time, No larger disc above smaller, 
 * 		   and only the top disc of a tower can be moved.
 */

public class TowerOfHanoi {

	static void towerOfHanoi(int n, char A, char B, char C) {
		if (n == 1) {
			System.out.println("Move 1 from " + A + " to " + C);
			return;
		}
		towerOfHanoi(n - 1, A, C, B);
		System.out.println("Move " + n + " from " + A + " to " + C);
		towerOfHanoi(n - 1, B, A, C);
	}

	public static void main(String[] args) {
		towerOfHanoi(3, 'A', 'B', 'C');
	}

}
