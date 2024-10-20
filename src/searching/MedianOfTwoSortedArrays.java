package searching;

/*- Given two sorted arrays, find the median of the two arrays combined.
 *  If the resulting array has odd no. of elements, the middle element is the median.
 *  If the resulting array has even no. of elements, the median is the average of the two middle elements.
 *  I/P: a1[] = {1, 5, 10} , a2[] = {2, 4, 8}
 *  O/P: {1, 2, 4, 5, 8, 10} => 4.5
 */
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] a1 = { 5, 8, 10, 15 }, a2 = { 3, 9, 12, 18 };
		System.out.println(getMedianEfficient(a1, a2));
	}

	// T(n): O(a1.length + a2.length)
	@SuppressWarnings("unused")
	private static float getMedian(int[] a1, int[] a2) {
		int n = a1.length + a2.length, p1 = 0, p2 = 0, i = 0;
		int[] arr = new int[n];
		while (i < n) {
			if (p2 == a2.length || (p1 < a1.length && a1[p1] < a2[p2])) {
				arr[i] = a1[p1];
				p1++;
			} else {
				arr[i] = a2[p2];
				p2++;
			}
			i++;
		}
		if (n % 2 == 0)
			return (arr[(n / 2) - 1] + arr[n / 2]) / 2.0f;
		else
			return arr[n / 2];
	}

	/*- Assuming a1 is smaller than or equal to a2. i1 and i2 are the mid indexes of a1 and a2.
	 * 	min1 is the beginning of right side in a1 and max1 is the end of left side in a1 (as is min2 and max2 in a2).
	 * 	T(n): O(log(n1))
	 */
	private static float getMedianEfficient(int[] a1, int[] a2) {
		int n1 = a1.length, n2 = a2.length, begin1 = 0, end1 = n1;
		while (begin1 <= end1) {
			int i1 = (begin1 + end1) / 2;
			int i2 = (n1 + n2 + 1) / 2 - i1;
			int min1 = (i1 == n1) ? Integer.MAX_VALUE : a1[i1];
			int max1 = (i1 == 0) ? Integer.MIN_VALUE : a1[i1 - 1];
			int min2 = (i2 == n2) ? Integer.MAX_VALUE : a2[i2];
			int max2 = (i2 == 0) ? Integer.MIN_VALUE : a2[i2 - 1];
			if (max1 <= min2 && max2 <= min1) {
				if ((n1 + n2) % 2 == 0)
					return ((float) Math.max(max1, max2) + Math.min(min1, min2)) / 2;
				else
					return (float) Math.max(max1, max2);
			} else if (max1 > min2)
				end1 = i1 - 1;
			else
				begin1 = i1 + 1;
		}
        throw new IllegalArgumentException("Input arrays are not sorted or are empty.");
	}

}
