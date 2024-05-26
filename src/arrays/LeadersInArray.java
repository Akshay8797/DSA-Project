package arrays;

/*- Given an array, print the Leaders in it
 *  An element is Leader, if no element in the right of it is greater.
 */

public class LeadersInArray {

	public static void main(String[] args) {
		int[] arr = { 7, 10, 4, 10, 3, 6, 5, 2 };
		printLeadersInArrayEff(arr);
	}

	@SuppressWarnings("unused")
	// T(n): O(n^2)
	private static void printLeadersInArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			boolean isLeader = true;
			for (int j = i + 1; j < n; j++) {
				if (arr[i] <= arr[j]) {
					isLeader = false;
					break;
				}
			}
			if (isLeader)
				System.out.println(arr[i]);
		}
	}

	// T(n): O(n)
	private static void printLeadersInArrayEff(int[] arr) {
		int n = arr.length, leftMaxSoFar = arr[n - 1];
		System.out.println(leftMaxSoFar);
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] > leftMaxSoFar) {
				leftMaxSoFar = arr[i];
				System.out.println(leftMaxSoFar);
			}
		}
	}

}
