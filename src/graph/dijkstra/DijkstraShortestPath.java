package graph.dijkstra;

import java.util.Arrays;

/*- Given an adjacency matrix representing an undirected, connected, weighted graph and a source vertex
 * 	Print the shortest distances of all the vertices from the source.
 */
public class DijkstraShortestPath {

	public static void main(String[] args) {
		int[][] graph = { { 0, 5, 10, 0 }, { 5, 0, 3, 20 }, { 10, 3, 0, 2 }, { 0, 20, 2, 0 } };
		int src = 0;
		int[] distances = getShortestPaths(graph, src);
		System.out.println("Shirtest distances from " + src + ": " + Arrays.toString(distances));
	}

	// T(n): O(V²), S(n): O(V²).
	private static int[] getShortestPaths(int[][] graph, int src) {
		int n = graph.length;
		int dist[] = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		boolean[] finalized = new boolean[n]; // finalized[i] is true if the shortest distance to i is found
		for (int count = 0; count < n - 1; count++) {
			int u = -1;
			// Pick the minimum distance vertex from the set of vertices not yet processed
			for (int i = 0; i < n; i++) {
				if (!finalized[i] && (u == -1 || dist[i] < dist[u]))
					u = i;
			}
			finalized[u] = true;
			// If the closest vertex is still unreachable, all the remaining are...
			if (dist[u] == Integer.MAX_VALUE) {
				break; // No need to proceed further
			}
			// Update dist[v] if not finalized & weight of path from src to v through u is smaller than dist[v].
			for (int v = 0; v < n; v++) { // Relax the adjacent of u
				if (!finalized[v] && graph[u][v] != 0)
					dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
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

}
