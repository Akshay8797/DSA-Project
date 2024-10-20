package searching;

/*- Given an array where all elements appear exactly once except one element which can appear any no. of times
 * 	Rules: 0 is always present in the array (arr). 
 * 		   If the max in arr is max(arr) then all the elements from 0 to max(arr) are present in arr.
 * 		   => 0 <= max(arr) <= n-2
 */
public class RepeatingElement {

	public static void main(String[] args) {
		int[] arr = { 0, 2, 1, 3, 5, 4, 6, 2 };
		System.out.println(getRepeatingElementEff(arr));
	}

	// T(n): O(n), S(n): O(n)
	@SuppressWarnings("unused")
	private static int getRepeatingElement(int[] arr) {
		int n = arr.length;
		boolean[] visited = new boolean[n - 1];
		for (int i = 0; i < n; i++) {
			if (visited[arr[i]])
				return arr[i];
			visited[arr[i]] = true;
		}
		return -1;
	}

	/*-	Use array elements as indexes to form a chain. 
	 * 	+1's are added to avoid self or unnecessary loops with 0 being in the array, giving wrong result.
	 *  -1 is done to get the original result back.
	 * 	T(n): O(n), S(n): O(1)
	 */
	private static int getRepeatingElementEff(int[] arr) {
		int slow = arr[0] + 1, fast = arr[0] + 1;
		do {
			slow = arr[slow] + 1;
			fast = arr[arr[fast] + 1] + 1;
		} while (slow != fast);
		slow = arr[0] + 1;
		System.out.println("Slow: " + slow + ", Fast: " + fast);
		while (slow != fast) {
			slow = arr[slow] + 1;
			fast = arr[fast] + 1;
		}
		return slow - 1;
	}

}
