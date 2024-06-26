package arrays;

import utils.ArrayUtils;

public class MaximumLengthEvenOddSubArray {

	public static void main(String[] args) {
		int[] arr = { 10, 12, 14, 7, 8 };
		System.out.println(getMaximumLengthSubArrayWIthEvenOdd(arr));
	}

	private static int getMaximumLengthSubArrayWIthEvenOdd(int[] arr) {
		int res = 1, curr = 1;
		for (int i = 1; i < arr.length; i++) {
			if ((ArrayUtils.isEven(arr[i - 1]) && !ArrayUtils.isEven(arr[i]))
					|| (!ArrayUtils.isEven(arr[i - 1]) && ArrayUtils.isEven(arr[i]))) {
				curr++;
				res = Math.max(res, curr);
			} else {
				curr = 1;
			}
		}
		return res;
	}

}
