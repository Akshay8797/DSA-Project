package arrays;

/*- Given a boolean array. Find the minimum flips to make the array elements same.
 * 	Allowed either flip of 0's or 1's. Consecutive 0's or 1's can be flipped in one go.
 * 	I/P: arr[] = {1,1,0,0,0,1} => O/P: From 2 to 4 (1 Flip).
 */
public class MinimumConsecutiveFlips {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 0, 0, 1, 0, 0, 1, 1 };
		printGroupsEfficient(arr);
	}

	// Tip: Always flip the second group
	private static void printGroupsEfficient(int[] arr) {
		int n = arr.length;
		for(int i=1; i<n; i++) {
			if (arr[i] != arr[i - 1]) {
				if(arr[i] != arr[0])
					System.out.print("From " + i);
				else
					System.out.print(" to " + (i - 1) + "\n");
			}
		}
		if(arr[n-1] != arr[0])
			System.out.print(" to " + (n - 1) + "\n");
	}
	
	@SuppressWarnings("unused")
	private static void printMinConsecutiveFlips(int[] arr) {
		int n = arr.length, flips0 = 0, flips1 = 0, i = 0;
		while (i < n) {
			if (arr[i] == 1) {
				while (i < n && arr[i] == 1)
					i++;
				flips1++;
			} else {
				while (i < n && arr[i] == 0)
					i++;
				flips0++;
			}
		}
		if (flips0 == 0 || flips1 == 0)
			return;
		if (flips0 < flips1)
			ArrayUtils.loopAndPrintFlips(arr, i = 0, 0);
		else
			ArrayUtils.loopAndPrintFlips(arr, i = 0, 1);
	}

}
