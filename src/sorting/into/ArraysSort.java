package sorting.into;

import java.util.Arrays;

public class ArraysSort {

	public static void main(String[] args) {

		Point arr[] = { new Point(10, 20), new Point(3, 12), new Point(5, 7) };
		Arrays.sort(arr); // Arrays.sort(arr, Collections.reverseOrder()); for reverse sort.
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));

		System.out.println();
		Arrays.sort(arr, new Point.PointComparatorY());
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));

	}

}