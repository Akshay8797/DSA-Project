package graph.core;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import utils.GraphUtils;

// Given an undirected disconnected graph(s) without any source, print BFS of the graph(s).
public class BfsOfDisconnected {

	public static void main(String[] args) {
		int[][] edges = { { 1, 3 }, { 0, 2 }, { 1 }, { 0 }, { 5 }, { 4 } };
		int vrtx = 6;
		List<List<Integer>> adj = GraphUtils.crateAdjList(vrtx, edges);
		boolean[] visited = new boolean[vrtx];
		for (int i = 0; i < vrtx; i++) {
			if (!visited[i])
				printBFSDis(adj, visited, i);
		}
	}

	// T(n): O(v+e), S(n): O(v).
	private static void printBFSDis(List<List<Integer>> adj, boolean[] visited, int s) {
		visited[s] = true;
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(s);
		while (!que.isEmpty()) {
			int u = que.poll();
			System.out.print(u + " ");
			for (int v : adj.get(u)) {
				if (!visited[v]) {
					que.offer(v);
					visited[v] = true;
				}
			}
		}
	}

}
