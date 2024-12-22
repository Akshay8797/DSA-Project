package sorting;

import java.util.Arrays;

/*- In-place and not stable.
 * 	For scenarios where minimum swaps are needed.
 */
public class CycleSort {

	public static void main(String[] args) {
		int[] arr = { 20, 40, 50, 10, 30 };
		cycleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void cycleSort(int[] arr) {
		int n = arr.length;
		for (int cs = 0; cs < n - 1; cs++) {
			int item = arr[cs];
			int pos = cs;
			for (int i = cs + 1; i < n; i++) {
				if (arr[i] < item)
					pos++;
			}
			if (pos == cs)
				continue;
			while (item == arr[pos]) // Skip duplicates
				pos++;
			item = swap(arr, item, pos);
			while (pos != cs) {
				pos = cs;
				for (int i = cs + 1; i < n; i++) {
					if (arr[i] < item)
						pos++;
				}
				while (item == arr[pos]) // Skip duplicates
					pos++;
				item = swap(arr, item, pos);
			}
		}
	}

	private static int swap(int[] arr, int item, int pos) {
		int temp = item;
		item = arr[pos];
		arr[pos] = temp;
		return item;
	}

}
