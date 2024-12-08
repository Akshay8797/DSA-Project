package sorting.into;

import java.util.Arrays;
import java.util.Comparator;

public class EvensFirst {

	public static void main(String[] args) {

		Integer arr[] = { 2, 5, 7, 6, 1, 8 };
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a % 2 - b % 2;
			}
		});
		System.out.println(Arrays.toString(arr));

	}

}
