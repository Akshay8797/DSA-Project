package graph.core;

import java.util.List;

import utils.GraphUtils;

/*- Given an undirected disconnected graph, 
 * 		find the no. of connected graphs or components in it using DFS. 
 */
public class ConnectedCompDFS {

	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 0 }, { 0 }, { 4 }, { 3, 5 }, { 4 } };
		int vrtx = 6;
		List<List<Integer>> adj = GraphUtils.crateAdjList(vrtx, edges);
		System.out.println(getCompCount(vrtx, adj));
	}

	// T(n): O(v+e), S(n): O(v).
	private static int getCompCount(int vrtx, List<List<Integer>> adj) {
		boolean[] visited = new boolean[vrtx];
		int compCount = 0;
		for (int i = 0; i < vrtx; i++) {
			if(!visited[i]) {
				compCount++;
				doDFS(adj, visited, i);
			}
		}
		return compCount;
	}

	private static void doDFS(List<List<Integer>> adj, boolean[] visited, int s) {
		visited[s] = true;
		for(int v : adj.get(s)) {
			if(!visited[v])
				doDFS(adj, visited, v);
		}
	}

}
