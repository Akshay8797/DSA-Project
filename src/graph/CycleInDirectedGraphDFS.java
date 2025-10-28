package graph;

import java.util.List;

import utils.GraphUtils;

public class CycleInDirectedGraphDFS {

	public static void main(String[] args) {
		int[][] edges = { { 1 }, {}, { 1, 3 }, { 4 }, { 2 } };
		int vrtx = 5;
		List<List<Integer>> adj = GraphUtils.buildGraph(vrtx, edges);
		boolean hasCycle = false, visited[] = new boolean[vrtx], recStk[] = new boolean[vrtx];
		for (int i = 0; i < vrtx; i++) {
			if (!visited[i]) {
				if (hasDirectedCycleDFS(adj, i, visited, recStk)) {
					hasCycle = true;
					break;
				}
			}
		}
		System.out.println("Cycle present: " + hasCycle);
	}

	private static boolean hasDirectedCycleDFS(List<List<Integer>> adj, int u, boolean[] visited, boolean[] recStk) {
		visited[u] = true;
		recStk[u] = true;
		for (int v : adj.get(u)) {
			if (!visited[v] && hasDirectedCycleDFS(adj, v, visited, recStk)) // Recursively DFS for unexplored v.
				return true;
			else if (recStk[v]) // Back edge to a visited vertex.
				return true;
		}
		recStk[u] = false;
		return false;
	}

}
