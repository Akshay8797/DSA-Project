package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*- Given an adjacency matrix representing an undirected, connected, weighted graph and a source vertex
 * 	Print the shortest distances of all the vertices from the source.
 */
public class DijkstraShortestPathEff {

	public static void main(String[] args) {
		List<List<Edge>> graph = new ArrayList<>();
		graph.add(List.of(new Edge(1, 5), new Edge(2, 10)));
		graph.add(List.of(new Edge(0, 5), new Edge(2, 3), new Edge(3, 20)));
		graph.add(List.of(new Edge(0, 10), new Edge(1, 3), new Edge(3, 2)));
		graph.add(List.of(new Edge(1, 20), new Edge(2, 2)));
		int src = 0;
		int[] distances = getShortestPaths(graph, src);
		System.out.println("Shortest distances from " + src + ": " + Arrays.toString(distances));
	}

	// T(n): O((V + E) log V), S(n): O(V + E).
	private static int[] getShortestPaths(List<List<Edge>> graph, int src) {
		int n = graph.size();
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE); // Initialize all distances to infinity and src to 0.
		dist[src] = 0;
		// Min Heap to select the next node with samllest distance.
		PriorityQueue<NodeEntry> minHeap = new PriorityQueue<>();
		minHeap.add(new NodeEntry(src, 0));
		boolean[] finalized = new boolean[n]; // finalized[i] is true if the shortest distance to i is found.
		while (!minHeap.isEmpty()) {
			NodeEntry curr = minHeap.poll();
			int u = curr.node;
			if (finalized[u]) // Skip if this node's shortest distance is already found.
				continue;
			finalized[u] = true;
			// Relax all adjacent edges
			for (Edge edg : graph.get(u)) {
				int v = edg.to(); // Neighbor node.
				if (finalized[v]) // Skip if neighbor is already finalized.
					continue;
				int wtV = edg.weight();
				int newDist = dist[u] + wtV;
				// If a shorter path to v is found, update and add to heap.
				if (dist[v] > newDist) {
					dist[v] = newDist;
					minHeap.offer(new NodeEntry(v, newDist));
				}
			}
		}
		// Set unreachable nodes' distances to -1.
		for (int i = 0; i < n; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				dist[i] = -1;
			}
		}
		return dist;
	}

	record Edge(int to, int weight) {
	};

	record NodeEntry(int node, int distance) implements Comparable<NodeEntry> {
		@Override
		public int compareTo(NodeEntry nodeEntry) {
			return Integer.compare(this.distance, nodeEntry.distance);
		}
	};

}
