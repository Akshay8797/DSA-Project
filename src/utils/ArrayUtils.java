package utils;

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

	public static boolean isEven(int a) {
		return (a % 2 == 0);
	}

	public static void loopAndPrintFlips(int[] arr, int index, int val) {
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

	public static int getArraySumFromToIndex(int[] arr, int j, int k) {
		int sum = 0;
		for (int i = j; i < k; i++)
			sum += arr[i];
		return sum;
	}

	public static int getArraySumIncl(int[] arr, int b, int e) {
		int sum = 0;
		for (int i = b; i <= e; i++)
			sum += arr[i];
		return sum;
	}

	public static void printFromIndexWithoutDup(int[] arr, int i, int n) {
		while (i < n) {
			if (i == 0 || arr[i] != arr[i - 1])
				System.out.println(arr[i]);
			i++;
		}
	}

	public static boolean isArrayValid(int[] arr) {
		return arr != null && arr.length > 0;
	}

	public static void swap(int[][] arr, int row1, int col1, int row2, int col2) {
		int temp = arr[row1][col1];
		arr[row1][col1] = arr[row2][col2];
		arr[row2][col2] = temp;
	}

	public static void print(int[][] arr, int row, int col) {
		System.out.print(arr[row][col] + " ");
	}

	public static void swapChar(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}

}
