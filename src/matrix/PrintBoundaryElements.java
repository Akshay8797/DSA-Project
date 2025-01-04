package matrix;

import utils.ArrayUtils;

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
		int rowCount = arr.length, colCount = arr[0].length;
		if (rowCount == 1) {
			for (int i = 0; i < colCount; i++)
				ArrayUtils.print(arr, 0, i);
		} else if (colCount == 1) {
			for (int i = 0; i < rowCount; i++)
				ArrayUtils.print(arr, i, 0);
		} else {
			for (int i = 0; i < colCount; i++)
				ArrayUtils.print(arr, 0, i);
			for (int i = 1; i < rowCount; i++)
				ArrayUtils.print(arr, i, colCount - 1);
			for (int i = colCount - 2; i >= 0; i--)
				ArrayUtils.print(arr, rowCount - 1, i);
			for (int i = rowCount - 2; i > 0; i--)
				ArrayUtils.print(arr, i, 0);
		}
	}

}
