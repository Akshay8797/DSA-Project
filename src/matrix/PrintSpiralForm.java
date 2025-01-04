package matrix;

import utils.ArrayUtils;

/*-	I/P:	1  2  3  4
 * 			5  6  7  8
 *			9  10 11 12
 *			13 14 15 16
 * 	O/P: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
 */
public class PrintSpiralForm {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printMatrixInSpiralForm(arr);
	}

	// T(n): O(r * c) - r: no. of rows, c: no. of columns.
	private static void printMatrixInSpiralForm(int[][] arr) {
		int top = 0, left = 0, bottom = arr.length - 1, right = arr[0].length - 1;
		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; i++)
				ArrayUtils.print(arr, top, i);
			top++;
			for (int i = top; i <= bottom; i++)
				ArrayUtils.print(arr, i, right);
			right--;
			if (top <= bottom) {
				for (int i = right; i >= left; i--)
					ArrayUtils.print(arr, bottom, i);
				bottom--;
			}
			if (left <= right) {
				for (int i = bottom; i >= top; i--)
					ArrayUtils.print(arr, i, left);
				left++;
			}
		}

	}

}
