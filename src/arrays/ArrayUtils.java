package arrays;

public class ArrayUtils {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void reverse(int[] arr, int low, int high) {
		while (low < high) {
			swap(arr, low, high);
			low++;
			high--;
		}
	}

}
