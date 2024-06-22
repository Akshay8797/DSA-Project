package arrays;

/*- Check if a sub-array exists with the given sum in an array with no -ve elements.
 *  I/P: [1,4,20,3,10,5], sum=33	=>	O/P: Yes.
 */
public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		int[] arr = { 2, 7, 2, 5, 10, 3 };
		System.out.println(isSubarrayWithGivenSum(arr, 6));
	}

	// Window sliding with variable size window.
	// T(n): O(n)
	private static boolean isSubarrayWithGivenSum(int[] arr, int givenSum) {
		int currSum = 0, start = 0;
		for (int end = 0; end < arr.length; end++) {
			currSum += arr[end];
			while (currSum > givenSum) {
				currSum -= arr[start];
				start++;
			}
			if (currSum == givenSum)
				return true;
		}
		return false;
	}

}
