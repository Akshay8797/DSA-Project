package arrays;

public class ArrayUtils {

	protected static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	protected static void reverse(int[] arr, int low, int high) {
		while (low < high) {
			swap(arr, low, high);
			low++;
			high--;
		}
	}

	protected static boolean isEven(int a) {
		return (a % 2 == 0);
	}

	protected static void loopAndPrintFlips(int[] arr, int index, int val) {
		while (index < arr.length) {
			if (arr[index] == val) {
				System.out.print("From " + index);
				while (index < arr.length && arr[index] == val)
					index++;
				System.out.print(" to " + (index - 1) + "\n");
			} else
				index++;
		}
	}

}
