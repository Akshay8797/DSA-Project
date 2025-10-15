package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import utils.GraphUtils;

/*- Given a directed acyclic graph, print its topological order.
 * 	If there is a path from vertex A to B, A must appear before B in the order.
 * 	Kahn's Algorithm (BFS-based):
 * 	- Repeatedly remove nodes with no incoming edges and append them to the order.
 * 	- Remove their outgoing edges from the graph and repeat.
 */
public class TopologicalSortingBFS {

	public static void main(String[] args) {
		int[][] edges = { { 2, 3 }, { 3, 4 }, { 3 }, {}, {} };
		int vrtx = 5;
		List<List<Integer>> adj = GraphUtils.crateAdjList(vrtx, edges);
		System.out.println(printTopologicalOrder(adj, vrtx));
	}

	// T(n): O(V + E).
	private static List<Integer> printTopologicalOrder(List<List<Integer>> adj, int vertexCount) {
		int[] inDegree = new int[vertexCount];
		// Calculate in degree of each vertex.
		for (List<Integer> row : adj) {
			for (int x : row)
				inDegree[x]++;
		}
		// Add all vertices with 0 in degree to queue.
		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 0; i < vertexCount; i++) {
			if (inDegree[i] == 0)
				que.add(i);
		}
		List<Integer> topoOrder = new ArrayList<>();
		int visitedCount = 0;
		/*- Remove a vertex from the queue, add it to the result and reduce the in degree of its adjacent vertexes.
		 * 	If any of the adjacent vertex has its in degree reduced to 0, add it to the queue and repeat.
		 */
		while (!que.isEmpty()) {
			int v = que.poll();
			topoOrder.add(v);
			visitedCount++;
			for (int u : adj.get(v)) {
				inDegree[u]--;
				if (inDegree[u] == 0)
					que.add(u);
			}
		}
		// Check for cycle before returning the topological order.
		if (visitedCount != vertexCount) {
			throw new IllegalStateException("Graph contains a cycle, Topological sort is not possible!");
		}
		return topoOrder;
	}

}
