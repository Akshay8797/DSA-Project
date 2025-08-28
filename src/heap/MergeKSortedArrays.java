package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

	public static void main(String[] args) {
		List<List<Integer>> sortedLists = List.of(List.of(10, 20, 30), List.of(5, 15), List.of(1, 9, 11, 18));
		List<Integer> mergedArr = mergeArr(sortedLists);
		System.out.println(mergedArr);
	}

	record Triplet(int val, int arrPos, int valPos) implements Comparable<Triplet> {
		@Override
		public int compareTo(Triplet otherTriplet) {
			return Integer.compare(this.val, otherTriplet.val);
		}
	}

	// T(n): n * k log k.
	private static List<Integer> mergeArr(List<List<Integer>> arr) {
		List<Integer> res = new ArrayList<>();
		int n = arr.size();
		PriorityQueue<Triplet> pq = new PriorityQueue<>(n);
		for (int i = 0; i < n; i++)
			pq.add(new Triplet(arr.get(i).get(0), i, 0));
		while (!pq.isEmpty()) {
			Triplet curr = pq.poll();
			res.add(curr.val);
			int arrPos = curr.arrPos, valPos = curr.valPos;
			if (valPos + 1 < arr.get(arrPos).size())
				pq.add(new Triplet(arr.get(arrPos).get(valPos + 1), arrPos, valPos + 1));
		}
		return res;
	}

}
