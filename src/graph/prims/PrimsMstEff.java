package graph.prims;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsMstEff {

	// Use adjacency list with a Min Heap.
	public static void main(String[] args) {
		List<List<Edge>> graph = new ArrayList<>();
		graph.add(List.of(new Edge(1, 5), new Edge(2, 8)));
		graph.add(List.of(new Edge(0, 5), new Edge(2, 10), new Edge(3, 15)));
		graph.add(List.of(new Edge(0, 8), new Edge(1, 10), new Edge(3, 20)));
		graph.add(List.of(new Edge(1, 15), new Edge(2, 20)));
		System.out.println("MST weight: " + getMstWeight(graph));
	}

	// T(n): O(E Log V), S(n): O(V + E).
	private static int getMstWeight(List<List<Edge>> graph) {
		int n = graph.size();
		int totalWeight = 0;

		// Min-heap to select the next edge with the smallest weight
		PriorityQueue<Edge> minHeap = new PriorityQueue<>();
		minHeap.offer(new Edge(0, 0)); // Start from vertex 0 with weight 0
		boolean[] inMST = new boolean[n];
		int verticesIncluded = 0;

		while (!minHeap.isEmpty() && verticesIncluded < n) {
			Edge current = minHeap.poll();
			// If vertex is already in MST, skip it
			if (inMST[current.to])
				continue;
			// Include vertex in MST
			inMST[current.to] = true;
			totalWeight += current.weight;
			verticesIncluded++;
			// Add all edges from the current vertex to the heap
			for (Edge neighbor : graph.get(current.to)) {
				if (!inMST[neighbor.to]) {
					minHeap.offer(neighbor);
				}
			}
		}
		// If not all vertices were included, the graph is disconnected
		return verticesIncluded == n ? totalWeight : -1;
	}

	record Edge(int to, int weight) implements Comparable<Edge> {
		@Override
		public int compareTo(Edge v) {
			return Integer.compare(this.weight, v.weight);
		}
	};

}
