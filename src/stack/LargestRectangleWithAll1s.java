package stack;

/*- Given a binary matrix, find the size of the largest rectangle (sub matrix) with all 1's.
 * 		0, 1, 1, 0
 * 		1, 1, 1, 1	=>	1, 1, 1, 1	=> 8
 * 		1, 1, 1, 1		1, 1, 1, 1
 * 		1, 1, 0, 0
 */

public class LargestRectangleWithAll1s {

	public static void main(String[] args) {
		int[][] mat = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		System.out.println(getLargestRectWith1sEff(mat));
	}

	// Consider each cell as a starting point. T(n): O(rows^2 x cols^2).
	static int getLargestRectWith1s(int[][] mat) {
		if (isMatrixInvalid(mat))
			return 0;
		int rows = mat.length, cols = mat[0].length, res = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (mat[i][j] != 0) {
					int minWidth = Integer.MAX_VALUE, height = 0;
					for (int r = i; r < rows; r++) {
						if (mat[r][j] == 1) {
							height++;
							int width = 0;
							for (int c = j; c < cols && mat[r][c] == 1; c++) {
								width++;
							}
							minWidth = Integer.min(minWidth, width);
							res = Integer.max(height * minWidth, res);
						} else {
							break; // No need to check next rows if 0 is encountered.
						}
					}
				}
			}
		}
		return res;
	}

	/*- Uses largest area in a histogram logic.
	 * 	Calculate the area for the base row, for next rows if cell has 1 add the upper cell.
	 * 	T(n): O(rows x cols).
	 */
	private static int getLargestRectWith1sEff(int[][] mat) {
		if (isMatrixInvalid(mat))
			return 0;
		int res = LargestRectangularAreaHistogram.getMaxAreaEff(mat[0]);
		for (int i = 1; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1)
					mat[i][j] += mat[i - 1][j];
			}
			res = Math.max(LargestRectangularAreaHistogram.getMaxAreaEff(mat[i]), res);
		}
		return res;
	}

	private static boolean isMatrixInvalid(int[][] mat) {
		return (mat == null || mat.length == 0 || mat[0].length == 0);
	}
}
