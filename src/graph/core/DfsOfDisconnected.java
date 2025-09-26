package graph.core;

import java.util.List;

import utils.GraphUtils;

// Given an undirected disconnected graph(s) without any source, print DFS of the graph(s).
public class DfsOfDisconnected {

	public static void main(String[] args) {
		int[][] edges = { { 1, 3 }, { 0, 2 }, { 1 }, { 0 }, { 5 }, { 4 } };
		int vrtx = 6;
		List<List<Integer>> adj = GraphUtils.crateAdjList(vrtx, edges);
		boolean[] visited = new boolean[vrtx];
		for (int i = 0; i < vrtx; i++) {
			if (!visited[i])
				DfsFromSource.printDFS(adj, visited, i);
		}
	}

}
