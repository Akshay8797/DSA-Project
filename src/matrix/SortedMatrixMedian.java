package matrix;

import java.util.Arrays;

import utils.MathUtils;

/*- Given an odd sized row-sorted matrix (Ex: 3x3, 3x5, etc) with all distinct elements.
 * 	Find the median of the matrix.
 * 	I/P:	1  10 20	=>	O/P: 20 (1, 5, 10, 15, 20, 25, 30, 35, 40).
 * 			15 25 35
 *			5  30 40
 */
public class SortedMatrixMedian {

	public static void main(String[] args) {
		int[][] arr = { { 1, 10, 20 }, { 15, 25, 35 }, { 5, 30, 40 } };
		System.out.println("Median: " + getMedianEff(arr));
	}

	// T(n): O(r * log(max - min) * log(c)).
	private static int getMedianEff(int[][] arr) {
		int r = arr.length, c = arr[0].length, min = arr[0][0], max = arr[0][c - 1];
		for (int i = 1; i < r; i++) {
			min = Math.min(arr[i][0], min);
			max = Math.max(arr[i][c - 1], max);
		}
		int medPos = (r * c + 1) / 2;
		// Min & Max are in the matrix, they would converge to a value in the matrix.
		while (min < max) {
			int mid = MathUtils.getMidpoint(min, max), midPos = 0;
			for (int i = 0; i < r; i++) {
				int pos = Arrays.binarySearch(arr[i], mid) + 1;
				midPos += Math.abs(pos); // count of elements <= mid
			}
			if (midPos < medPos)
				min = mid + 1;
			else
				max = mid;
		}
		return min;
	}

	// T(n): O(rows x columns), S(n): O(columns)
	static int getMedian(int[][] arr) {
		int rows = arr.length, left[] = arr[0], cols = left.length;
		for (int r = 1; r < rows; r++) {
			int i = 0, j = 0, k = 0;
			int merged[] = new int[left.length + cols];
			while (i < left.length && j < cols) {
				if (left[i] <= arr[r][j]) {
					merged[k] = left[i];
					i++;
				} else {
					merged[k] = arr[r][j];
					j++;
				}
				k++;
			}
			while (i < left.length) {
				merged[k] = left[i];
				i++;
				k++;
			}
			while (j < cols) {
				merged[k] = arr[r][j];
				j++;
				k++;
			}
			left = merged;
		}
		return left[(rows * cols) / 2];
	}

}
