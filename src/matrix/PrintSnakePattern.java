package matrix;

/*-	I/P:	1  2  3  4
 * 			5  6  7  8
 *			9  10 11 12
 *			13 14 15 16
 * 	O/P: 1 2 3 4 8 7 6 5 9 10 11 12 16 15 14 13 
 */
public class PrintSnakePattern {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printMatrixInSnakePattern(arr);
	}

	// T(n): O(r * c) - r: no. of rows, c: no. of columns.
	private static void printMatrixInSnakePattern(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr[i].length; j++)
					System.out.print(arr[i][j] + " ");
			} else {
				for (int j = arr.length - 1; j >= 0; j--)
					System.out.print(arr[i][j] + " ");
			}
		}
	}

}
