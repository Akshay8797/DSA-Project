package graph.core;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import utils.GraphUtils;

/*- Given an undirected disconnected graph, 
 * 		find the no. of connected graphs or components in it using BFS. 
 */
public class ConnectedCompBFS {

	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 0, 2 }, { 0, 1 }, { 4 }, { 3 } };
		int vrtx = 5;
		List<List<Integer>> adj = GraphUtils.crateAdjList(vrtx, edges);
		System.out.println(getCompCount(vrtx, adj));
	}

	// T(n): O(v+e), S(n): O(v).
	private static int getCompCount(int vrtx, List<List<Integer>> adj) {
		int compCount = 0;
		boolean[] visited = new boolean[vrtx];
		for (int i = 0; i < vrtx; i++) {
			if (!visited[i]) {
				compCount++;
				doBfs(adj, vrtx, i, visited);
			}
		}
		return compCount;
	}

	private static void doBfs(List<List<Integer>> adj, int vrtx, int src, boolean[] visited) {
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(src);
		while (!que.isEmpty()) {
			int u = que.poll();
			for (int v : adj.get(u)) {
				if (!visited[v]) {
					que.offer(v);
					visited[v] = true;
				}
			}
		}
	}

}
