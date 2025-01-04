package matrix;

import java.util.Arrays;

import utils.ArrayUtils;

/*- Given nxn matrix, rotate it by 90 degrees counter-clockwise.
 * 	I/P:  1 2 3		O/P:  3 6 9 
 * 		  4 5 6			  2 5 8
 *		  7 8 9			  1 4 7
 */
public class MatrixRotation {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotateMatrix90Eff(arr);
		for (int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}
	}

	// T(n): O(n^2), S(n): O(n^2)
	static void rotateMatrixBy90(int[][] arr) {
		int n = arr.length, temp[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[n - 1 - j][i] = arr[i][j];
			}
		}
		for (int i = 0; i < temp.length; i++) {
			System.arraycopy(temp[i], 0, arr[i], 0, temp[i].length);
		}
	}

	// T(n): O(n^2), S(n): O(1)
	private static void rotateMatrix90Eff(int[][] arr) {
		MatrixTranspose.transposeMatrix(arr);
		// Swapping column elements
		for (int i = 0; i < arr.length; i++) {
			int low = 0, high = arr.length - 1;
			while (low < high) {
				ArrayUtils.swap(arr, low, i, high, i);
				low++;
				high--;
			}
		}
	}

}
