package sorting;

import java.util.Arrays;

/*- Consider an event from 00 to 23:59 => arr[] and dep[] rep. time of arrivals and departure of guests 
 * 	0 <= arr[], dep[] <= 2359. Find the maximum no. of guests you can meet.
 * 	I/P: arr[] = {900, 940}, dep[] = {1000, 1030} => O/P: 2 (From 940 to 1000)
 */
public class MeetingMaxGuests {

	public static void main(String[] args) {
		int[] arr = { 900, 600, 700 };
		int[] dep = { 1000, 800, 730 };
		System.out.println(getMaxGuests(arr, dep));
	}

	// T(n): O(n * log n)
	private static int getMaxGuests(int[] arr, int[] dep) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i = 1, j = 0, res = 1, guests = 1;
		while (i < arr.length && j < dep.length) { // arr.length equals dep.length
			if (arr[i] <= dep[j]) {
				guests++;
				i++;
			} else {
				guests--;
				j++;
			}
			res = Math.max(res, guests);
		}
		return res;
	}

}
