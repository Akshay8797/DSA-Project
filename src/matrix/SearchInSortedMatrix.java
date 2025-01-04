package matrix;

/*- Given a row-wise and column-wise sorted (increasing) matrix and an int x.
 * 	If x is present print it's position else not found.
 * 	I/P:	10 20 30 40    , and x = 29
 * 			15 25 35 45
 *			27 29 37 48
 *			32 33 39 50
 * 	O/P: Found at (2,1)
 */
public class SearchInSortedMatrix {

	public static void main(String[] args) {
		int[][] arr = { { 10, 20, 30, 40 }, { 15, 25, 25, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		isPresent(arr, 29);
	}

	// T(n): O(rows + columns)
	private static void isPresent(int[][] arr, int x) {
		int rows = arr.length, cols = arr[0].length;
		if (x < arr[0][0] || x > arr[rows - 1][cols - 1]) {
			System.out.println("Not Found");
		}
		int i = 0, j = cols - 1;
		while (i < rows && j >= 0) {
			if (arr[i][j] == x) {
				System.out.println("Found at (" + i + ", " + j + ")");
				return;
			} else if (arr[i][j] > x)
				j--;
			else
				i++;
		}
		System.out.println("Not Found");
	}

}
