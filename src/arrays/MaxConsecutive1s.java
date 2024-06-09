package arrays;

// Given a binary array. Find the maximum no. of consecutive 1's in it.
public class MaxConsecutive1s {

	public static void main(String[] args) {
		int[] arr = { 1, 0, 1, 0, 1, 1 };
		System.out.println(getMaxConsecutive1s(arr));
	}

	private static int getMaxConsecutive1s(int[] arr) {
		int count = 0, max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				count++;
				max = Math.max(max, count);
			} else
				count = 0;
		}
		return max;
	}

}
