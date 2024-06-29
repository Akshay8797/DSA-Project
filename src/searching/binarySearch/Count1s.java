package searching.binarySearch;

import utils.MathUtils;

/*- Given a sorted binary array. Count 1's in it.
 * 	I/P: arr[] = {0,0,0,1,1,1,1}	=>		O/P: 4
 */
public class Count1s {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 0, 1, 1, 1 };
		System.out.println(get1sCount(arr));
	}

	private static int get1sCount(int[] arr) {
		int n = arr.length, low = 0, high = n - 1;
		while (low <= high) {
			int mid = MathUtils.getMidpoint(low, high);
			if (arr[mid] == 0)
				low = mid + 1;
			else {
				if (mid == 0 || arr[mid - 1] == 0) // since binary array
					return (n - mid);
				else
					high = mid - 1;
			}
		}
		return 0;
	}

}
