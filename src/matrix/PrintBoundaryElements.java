package matrix;

/*-	I/P:	1  2  3  4
 * 			5  6  7  8
 *			9  10 11 12
 *			13 14 15 16
 * 	O/P: 1 2 3 4 8 12 16 15 14 13 9 5 
 */
public class PrintBoundaryElements {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printMatrixInBoundaryTraversal(arr);
	}

	// T(n): O(r + c) - r: no. of rows, c: no. of columns.
	private static void printMatrixInBoundaryTraversal(int[][] arr) {
		int rowCount = arr.length, columnCount = arr[0].length;
		if (rowCount == 1) {
			for (int i = 0; i < columnCount; i++)
				System.out.print(arr[0][i] + " ");
		} else if (columnCount == 1) {
			for (int i = 0; i < rowCount; i++)
				System.out.print(arr[i][0] + " ");
		} else {
			for (int i = 0; i < columnCount; i++) {
				System.out.print(arr[0][i] + " ");
			}
			for (int i = 1; i < rowCount; i++) {
				System.out.print(arr[i][columnCount - 1] + " ");
			}
			for (int i = columnCount - 2; i >= 0; i--) {
				System.out.print(arr[rowCount - 1][i] + " ");
			}
			for (int i = rowCount - 2; i > 0; i--) {
				System.out.print(arr[i][0] + " ");
			}
		}
	}

}
