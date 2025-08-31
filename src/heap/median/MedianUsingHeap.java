package heap.median;

import java.util.Collections;
import java.util.PriorityQueue;

/*- Given a Stream or Array, find the median at each point.
 * 	Median is the middle value when the numbers of the sequence are arranged in order, 
 * 	If the sequence has even no. of items, Median is the average of two middle values. 
 * 	Ex: [25, 7, 10, 15, 20] => 25, 16, 10, 12.5, 15
 */
public class MedianUsingHeap {

	public static void main(String[] args) {
		int[] arr = { 25, 7, 10, 15, 20 };
		printMedians(arr);
	}

	/*- Maintain two containers C1 and C2, containing smaller and greater half elements.
	 * 	If odd elements, then the C1 will have an extra element.
	 * 	If odd elements, then median is the max elements in the C1.
	 * 	If even elements, then median is the max of C1 and min of C2.
	 * 	T(n): O(n * log n).
	 */
	private static void printMedians(int[] arr) {
		if (arr == null || arr.length == 0)
			return;
		PriorityQueue<Integer> maxHpC1 = new PriorityQueue<>(Collections.reverseOrder()),
				minHpC2 = new PriorityQueue<>();
		maxHpC1.add(arr[0]);
		System.out.print(arr[0] + " ");
		for (int i = 1; i < arr.length; i++) {
			int x = arr[i];
			if (maxHpC1.size() > minHpC2.size()) {
				if (maxHpC1.peek() > x) {
					minHpC2.add(maxHpC1.poll());
					maxHpC1.add(x);
				} else
					minHpC2.add(x);
				System.out.print((maxHpC1.peek() + minHpC2.peek()) / 2.0 + " ");
			} else { // maxHeapC1's size equals minHeapC2's size.
				if (x > minHpC2.peek()) {
					maxHpC1.add(minHpC2.poll());
					minHpC2.add(x);
				} else
					maxHpC1.add(x);
				System.out.print(maxHpC1.peek() + " ");
			}
		}
	}

}
