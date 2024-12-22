package sorting;

import java.util.Arrays;

public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		Interval[] arr = { new Interval(1, 3), new Interval(2, 4), new Interval(5, 7), new Interval(6, 7) };
		getOverlappingIvals(arr);
	}

	// T(n): O(n * log n)
	private static void getOverlappingIvals(Interval[] arr) {
		boolean isValid = Arrays.stream(arr).allMatch(intr -> intr.start > 0 && intr.end > 0 && intr.start < intr.end);
		if (isValid) {
			Arrays.sort(arr, (a, b) -> Integer.compare(a.start, b.start));
			int res = 0;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i].start <= arr[res].end)
					arr[res].end = Math.max(arr[res].end, arr[i].end);
				else {
					res++;
					arr[res] = arr[i];
				}
			}
			for (int i = 0; i <= res; i++) {
				System.out.println(arr[i]);
			}
		} else
			System.out.println("Intervals are not valid!");
	}

}

class Interval {

	int start, end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "[" + start + ", " + end + "]";
	}

}
