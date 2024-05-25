package arrays;

// Return the index of the 2nd largest element
public class SecondLargestElement {

	public static void main(String[] args) {
		int[] arr = { 20, 10, 20, 8, 12, 7 };
		System.out.println(getSecodLargestInArray(arr));

	}

	private static int getSecodLargestInArray(int[] arr) {
		int largestId = 0, nextLargestId = -1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[largestId]) {
				nextLargestId = largestId;
				largestId = i;
			} else if ((arr[i] < arr[largestId]) && (nextLargestId == -1 || (arr[i] > arr[nextLargestId]))) {
				nextLargestId = i;
			}
		}
		return nextLargestId;
	}

}
