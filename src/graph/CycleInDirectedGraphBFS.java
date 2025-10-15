package graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import utils.GraphUtils;

// T(n): O(V+E) - Kahn's algorithm won't process all vertices if cycle is present.
public class CycleInDirectedGraphBFS {

	public static void main(String[] args) {
		int[][] edges = { { 1 }, {}, { 1, 3 }, { 4 }, { 2 } };
		int vrtx = 5;
		List<List<Integer>> adj = GraphUtils.crateAdjList(vrtx, edges);
		System.out.println(hasDirectedCycleBFS(adj, vrtx));
	}

	private static boolean hasDirectedCycleBFS(List<List<Integer>> adj, int vertexCount) {
		int[] inDegree = new int[vertexCount];
		for (List<Integer> row : adj) {
			for (int x : row)
				inDegree[x]++;
		}
		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 0; i < vertexCount; i++) {
			if (inDegree[i] == 0)
				que.add(i);
		}
		int visitedCount = 0;
		while (!que.isEmpty()) {
			int v = que.poll();
			visitedCount++;
			for (int u : adj.get(v)) {
				inDegree[u]--;
				if (inDegree[u] == 0)
					que.add(u);
			}
		}
		return visitedCount != vertexCount;
	}

}
