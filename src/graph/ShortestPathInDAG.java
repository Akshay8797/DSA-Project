package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import utils.GraphUtils;
import utils.GraphUtils.Edge;

/*- Given a Directed acyclic graph (no cycles) and a source vertex.
 * 	Find the shortest distance from the source vertex to all other vertices in the graph.
 */
public class ShortestPathInDAG {

	public static void main(String[] args) {
		List<int[]> edges = List.of(new int[] { 0, 1, 1 }, new int[] { 1, 2, 3 }, new int[] { 1, 3, 2 },
				new int[] { 2, 3, 4 });
		List<List<Edge>> adj = GraphUtils.buildWeightedGraph(4, edges);
		GraphUtils.printWeightedGraph(adj);
		System.out.println();
		shortestPathFromSrc(adj, 4, 1);
	}

	private static void shortestPathFromSrc(List<List<Edge>> adj, int vertices, int src) {
		// Perform topological sort.
		Deque<Integer> stack = new ArrayDeque<>(vertices);
		boolean visited[] = new boolean[vertices];
		for (int u = 0; u < vertices; u++) {
			if (!visited[u])
				doDFS(adj, u, stack, visited);
		}

		// Initialize the distance array.
		int dist[] = new int[vertices];
		Arrays.fill(dist, -1);
		dist[src] = 0;

		// Relax edges in Topological order.
		while (!stack.isEmpty()) {
			int u = stack.pop();
			// If the node is reachable from source
			if (dist[u] != -1) {
				for (Edge edge : adj.get(u)) {
					int v = edge.to();
					int weight = edge.weight();
					// Relaxation: If v has not been reached yet or if a shorter path found via u.
					if (dist[v] == -1 || dist[v] > dist[u] + weight) {
						dist[v] = dist[u] + weight;
					}
				}
			}
		}
		System.out.println("Distances from " + src + ": " + Arrays.toString(dist));
	}

	private static void doDFS(List<List<Edge>> adj, int u, Deque<Integer> stack, boolean[] visited) {
		visited[u] = true;
		for (Edge e : adj.get(u)) {
			if (!visited[e.to()])
				doDFS(adj, e.to(), stack, visited);
		}
		stack.push(u);
	}

}
