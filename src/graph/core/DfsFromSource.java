package graph.core;

import java.util.List;

import utils.GraphUtils;

/*- Given an undirected connected graph and the source, print DFS of the graph.
 * 	DFS (Depth-First Search): Explores as far as possible along each branch before backtracking.
 * 		DFS traverses the graph by going deep into one path, then backtracks.
 */
public class DfsFromSource {

	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 0, 3, 4 }, { 0, 3 }, { 1, 2 }, { 1, 5 }, { 4 } };
		int vrtx = 6;
		List<List<Integer>> adj = GraphUtils.crateAdjList(vrtx, edges);
		boolean[] visited = new boolean[vrtx];
		printDFS(adj, visited, 0);
	}

	// T(n): O(v+e), S(n): O(v).
	static void printDFS(List<List<Integer>> adj, boolean[] visited, int s) {
		visited[s] = true;
		System.out.print(s + " ");
		for (int v : adj.get(s)) {
			if (!visited[v])
				printDFS(adj, visited, v);
		}
	}

}
