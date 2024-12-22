package matrix;

import java.util.Arrays;

/*- Given nxn matrix, convert to its transpose - rows changes to columns and vice-versa.	
 * 	I/P:	1  2  3  4		O/P:	1 5 9  13
 * 			5  6  7  8			  	2 6 10 14
 *			9  10 11 12				3 7 11 15
 *			13 14 15 16				4 8 12 16
 */
public class MatrixTranspose {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		transposeMatrix(arr);
	}

	private static void transposeMatrix(int[][] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		for (int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}
	}

}
