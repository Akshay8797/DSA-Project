package utils;

public class MathUtils {

	public static int getMidpoint(int low, int high) {
		// To avoid overflow with (low + high) / 2
		return low + (high - low) / 2;
	}

	public static int doBinarySearch(int[] arr, int element, int low, int high) {
		while (low <= high) {
			int mid = getMidpoint(low, high);
			if (arr[mid] == element)
				return mid;
			if (arr[mid] > element)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	// Check if k students can read p pages with arr as the array of pages
	public static boolean isFeasible(int arr[], int k, int p) {
		int reqStud = 1, sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (sum + arr[i] > p) {
				reqStud++;
				sum = arr[i];
			} else
				sum += arr[i];
		}
		return (reqStud <= k);
	}

	public static int calculateExpr(int a, int b, String operator) {
		if (operator == "/" && b == 0)
			throw new ArithmeticException("Division by zero!");
		return switch (operator) {
		case "+" -> a + b;
		case "-" -> a - b;
		case "*" -> a * b;
		case "/" -> a / b;
		case "^" -> (int) Math.round(Math.pow(a, b));
		default -> throw new IllegalArgumentException("Invalid operator: " + operator + "!");
		};
	}

}
