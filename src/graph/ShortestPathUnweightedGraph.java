package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import utils.GraphUtils;

public class ShortestPathUnweightedGraph {

	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 0, 2, 3 }, { 0, 1, 3 }, { 1, 2 } };
		int vrtx = 4;
		List<List<Integer>> adj = GraphUtils.buildGraph(vrtx, edges);
		printShortestPathsFromSource(adj, 0);
	}

	// T(n): O(v+e).
	private static void printShortestPathsFromSource(List<List<Integer>> adj, int src) {
		int vrtx = adj.size();
		boolean[] visited = new boolean[vrtx];
		int[] dist = new int[vrtx];
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(src);
		visited[src] = true;
		dist[src] = 0;
		while (!que.isEmpty()) {
			int u = que.poll();
			for (int v : adj.get(u)) {
				if (!visited[v]) {
					dist[v] = dist[u] + 1;
					que.offer(v);
					visited[v] = true;
				}
			}
		}
		System.out.println(Arrays.toString(dist));

	}

}
